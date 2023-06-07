package ru.rgrtu.fvt.dto;

public class TaskParameter {
    int leftLine;
    int rightLine;
    int countSpace;

    public int getLeftLine() {
        return leftLine;
    }

    public int getRightLine() {
        return rightLine;
    }

    public int getCountSpace() {
        return countSpace;
    }

    public TaskParameter(int leftLine, int rightLine, int countSpace) {
        this.leftLine = leftLine;
        this.rightLine = rightLine;
        this.countSpace = countSpace;
    }
}
