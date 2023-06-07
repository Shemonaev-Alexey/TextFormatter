package ru.rgrtu.fvt.enums;

import ru.rgrtu.fvt.dto.TaskParameter;
import ru.rgrtu.fvt.exception.TextFormatterException;
import ru.rgrtu.fvt.text_format.FormatterByOne;
import ru.rgrtu.fvt.text_format.FormatterByTwo;

public enum FormatVariables {
    ONE(1) {
        @Override
        public String startFormat(TaskParameter params, String text) {
            return new FormatterByOne(params.getLeftLine(),
                    params.getRightLine(),
                    params.getCountSpace()).format(text);
        }
    },
    TWO(2) {
        @Override
        public String startFormat(TaskParameter params, String text) {
            return new FormatterByTwo(params.getLeftLine(),
                    params.getRightLine(),
                    params.getCountSpace()).format(text);
        }
    };

    final Integer variable;

    FormatVariables(Integer variable) {
        this.variable = variable;
    }

    public abstract String startFormat(TaskParameter params, String text);

    public static FormatVariables getByVariable(int value) {
        FormatVariables result = null;
        for (FormatVariables instance : FormatVariables.values()) {
            if (instance.variable == value) {
                result = instance;
            }
        }
        if (result == null) {
            throw new TextFormatterException("This variable is not correct");
        }
        return result;
    }
}
