package main.java;

import java.util.List;

// напишите метод equals для класса DuFile
public class One {

    private static class DuFile {

        // глубина файла
        final int depth;

        // полный путь (с именем)
        final String path;

        // если директория, то содержание директории
        // иначе null
        final List<DuFile> children;

        DuFile(int depth, String path, List<DuFile> children) {
            this.depth = depth;
            this.path = path;
            this.children = children;
        }
    }
}
