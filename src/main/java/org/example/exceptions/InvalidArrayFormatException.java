package org.example.exceptions;

public class InvalidArrayFormatException extends Exception {
    public InvalidArrayFormatException(String message) {
        super(message);
    }

    public InvalidArrayFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}

