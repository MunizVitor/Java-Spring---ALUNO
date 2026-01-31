package com.estudo.java.spring.CompaninVTR.exception;

public class AlunoExceptions extends Exception {

    private static final long serialVersionUID = -6681777147239341684L;

    public AlunoExceptions() {
        super();
    }

    public AlunoExceptions(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AlunoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AlunoExceptions(String message) {
        super(message);
    }

    public AlunoExceptions(Throwable cause) {
        super(cause);
    }

}