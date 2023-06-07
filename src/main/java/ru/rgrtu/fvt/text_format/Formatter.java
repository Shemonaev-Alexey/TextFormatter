package ru.rgrtu.fvt.text_format;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Formatter {
    Integer leftLine;
    Integer rightLine;
    Integer countSpaces;

    public Formatter(Integer leftLine, Integer rightLine, Integer countSpaces) {
        this.leftLine = leftLine;
        this.rightLine = rightLine;
        this.countSpaces = countSpaces;
    }

    public abstract String format(String text);

    protected String getSpaces(int countSpaces) {
        return " ".repeat(Math.max(0, countSpaces));
    }

    protected List<String> getParagraphs(String text) {
        return Arrays.stream(text.split("\r\n"))
                .map(line -> "\r\n" + getSpaces(countSpaces) + line).collect(Collectors.toList());
    }

    protected int getSpaceIndex(char[] array, int startIndex) {
        for (int i = startIndex; i != 0; ) {
            if (array[i] == ' ') {
                return i;
            }
            i--;
        }
        return 0;
    }
}
