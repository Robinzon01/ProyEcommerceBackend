package com.robin.proyecommer.backend.repository.exception;

public class ExceptionRepository extends Exception{
    private static final long serialVersionUID = 1L;

    public ExceptionRepository() {
    }

    public ExceptionRepository(String message) {
        super(message);
    }

    public ExceptionRepository(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionRepository(Throwable cause) {
        super(cause);
    }

    public ExceptionRepository(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
