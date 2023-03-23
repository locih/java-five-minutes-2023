import java.util.*;
import java.util.function.BiFunction;

public class CollectionUtils {

    private CollectionUtils() {
    }

    /**
     * Creates a reverse iterator.
     * <br/>
     * Note that after calling this method original iterator is invalidated.
     */
    public static <T> Iterator<T> reverse(Iterator<T> iterator) {
        Deque<T> deque = new ArrayDeque<>();
        iterator.forEachRemaining(deque::addFirst);
        return deque.iterator();
    }

    /**
     * Creates a reverse iterator based on given list iterator.
     * <br/>
     * This is a version of a {@link #reverse(Iterator)} with less memory consumption.
     * <br/>
     * Note that after calling this method original iterator is invalidated.
     */
    public static <T> Iterator<T> listReverse(ListIterator<T> iterator) {
        iterator.forEachRemaining(__ -> {});
        class ReverseIterator implements Iterator<T> {

            @Override
            public boolean hasNext() {
                return iterator.hasPrevious();
            }

            @Override
            public T next() {
                return iterator.previous();
            }
        }
        return new ReverseIterator();
    }

    /**
     * Creates an iterator that runs given iterators sequentially.
     * <br/>
     * It is expected that original iterators are not used after this method has been called.
     */
    @SafeVarargs
    public static <T> Iterator<T> append(Iterator<T> first, Iterator<T>... rest) {
        List<Iterator<T>> iterators = new ArrayList<>();
        if (first.hasNext()) {
            iterators.add(first);
        }
        for (Iterator<T> iterator : rest) {
            if (iterator.hasNext()) {
                iterators.add(iterator);
            }
        }

        class IteratorOfIterators implements Iterator<T> {

            int nIterator;

            @Override
            public boolean hasNext() {
                if (nIterator >= iterators.size()) return false;
                Iterator<T> cur = iterators.get(nIterator);
                return cur.hasNext();
            }

            @Override
            public T next() {
                Iterator<T> cur = iterators.get(nIterator);
                T el = cur.next();
                if (!cur.hasNext()) {
                    nIterator++;
                }
                return el;
            }
        }
        return new IteratorOfIterators();
    }

    /*
    Написать метод zip, который принимает на вход две коллекции и конвертер, на выходе дает новую коллекцию с преобразованными элементами.
    Если коллекции разной длины, то кидает исключение IllegalArgumentException.

    Пример:

    Collection<Integer> result = zip(List.of(1, 2, 3), List.of(3, 4, 5), (i, j) -> i * j);

    for (Integer i : result) {
      System.out.println(result);
    }

    Вывод:

    3
    8
    15

    Подсказка: java.util.function для ковертера
     */
    public static<T, V, U> Collection<U> zip(Collection<T> first,
                                             Collection<V> second,
                                             BiFunction<T, V, U> converter) {
        if (first.size() != second.size()) {
            throw new IllegalArgumentException("Expected collections of a same size");
        }
        List<U> result = new ArrayList<>();
        Iterator<T> firstIterator = first.iterator();
        Iterator<V> secondIterator = second.iterator();
        while (firstIterator.hasNext()) {
            T el1 = firstIterator.next();
            V el2 = secondIterator.next();
            result.add(converter.apply(el1, el2));
        }
        return result;
    }
}
