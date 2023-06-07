package ru.rgrtu.fvt.text_format;

import ru.rgrtu.fvt.dto.LetterData;

import java.util.List;

public class FormatterByTwo extends Formatter {
    public FormatterByTwo(Integer leftLine, Integer rightLine, Integer countSpaces) {
        super(leftLine, rightLine, countSpaces);
    }

    @Override
    public String format(String text) {
        StringBuffer resultText = new StringBuffer();
        List<String> rows = getParagraphs(text);
        rows.forEach(line -> {
            char[] array = line.toCharArray();
            int startIndex = 0;
            for (Integer i = rightLine; i < array.length; ) {
                LetterData letterData = getLetterIndex(array, i);
                resultText
                        .append(line, startIndex, letterData.getIndex());
                if (letterData.getSimbol()) {
                    resultText.append("\r\n");
                } else {
                    resultText.append("-\r\n").append(getSpaces(leftLine)).append("-");
                }
                startIndex = letterData.getIndex();
                i = letterData.getIndex() + rightLine;
            }
            resultText
                    .append(line, startIndex, array.length);
        });
        return resultText.toString();
    }

    private LetterData getLetterIndex(char[] array, int startIndex) {
        if (Character.isLetter(array[startIndex])) {
            return getTransferIndex(array, startIndex);
        } else {
            return new LetterData(true, startIndex);
        }
    }

    private LetterData getTransferIndex(char[] array, int index) {
        if (index - getSpaceIndex(array, index) < 4) {
            return new LetterData(true, getSpaceIndex(array, index));
        }
        if (isVowel(array, index) && isVowel(array, index - 1)) {
            return new LetterData(false, index - 1);
        }
        if (!isVowel(array, index) && !isVowel(array, index - 1)) {
            return new LetterData(false, index - 1);
        }
        if (!isVowel(array, index) && isVowel(array, index - 1)) {
            return new LetterData(false, index - 1);
        }
        return null;
    }

    private boolean isVowel(char[] array, int index) {
        String[] vowels = {"a", "о", "и", "е", "ё", "э", "ы", "у", "ю", "я"};
        boolean isVowel = false;
        for (String c : vowels) {
            if (String.valueOf(array[index]).equals(c)) {
                isVowel = true;
                break;
            }
        }
        return isVowel;
    }
}
