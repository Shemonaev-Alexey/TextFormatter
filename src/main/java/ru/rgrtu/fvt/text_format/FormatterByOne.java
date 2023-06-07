package ru.rgrtu.fvt.text_format;

import java.util.List;

public class FormatterByOne extends Formatter {
    public FormatterByOne(Integer leftLine, Integer rightLine, Integer countSpaces) {
        super(leftLine, rightLine, countSpaces);
    }

    @Override
    public String format(String text) {
        StringBuffer resultText = new StringBuffer();
        // add spaces by paragraph by countSpace parameter
        List<String> rows = getParagraphs(text);
        // add symbol to next line by rightLine parameter
        rows.forEach(line -> {
            char[] array = line.toCharArray();
            int startIndex = 0;
            for (Integer i = rightLine; i < array.length; ) {
                int spaceIndex = getSpaceIndex(array, i);
                resultText
                        .append(line, startIndex, spaceIndex)
                        .append("\r\n")
                        .append(getSpaces(leftLine));
                startIndex = spaceIndex;
                i = spaceIndex + rightLine;
            }
            resultText
                    .append(line, startIndex, array.length);
        });
        return resultText.toString().replaceFirst("\r\n", "");
    }
}
