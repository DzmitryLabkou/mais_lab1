package org.example.exceptions;

public class InvalidSortAlgorithmException extends RuntimeException {
    public InvalidSortAlgorithmException(String message) {
        super(message);
    }

    public InvalidSortAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
