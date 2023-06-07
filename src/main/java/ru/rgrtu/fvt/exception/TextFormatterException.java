package ru.rgrtu.fvt.exception;

public class TextFormatterException extends RuntimeException {
    public TextFormatterException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextFormatterException(String message) {
        super(message);
    }
}
