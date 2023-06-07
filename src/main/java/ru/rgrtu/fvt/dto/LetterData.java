package ru.rgrtu.fvt.dto;

public class LetterData {
    Boolean isSimbol;
    int index;

    public LetterData(Boolean isSimbol, int index) {
        this.isSimbol = isSimbol;
        this.index = index;
    }

    public Boolean getSimbol() {
        return isSimbol;
    }

    public int getIndex() {
        return index;
    }
}
