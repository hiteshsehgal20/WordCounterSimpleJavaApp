package org.example.wordcounter.exception;

public class InvalidWordException extends RuntimeException {
    public InvalidWordException() {
        super();
    }

    public InvalidWordException(String cause) {
        super(cause);

    }
}
