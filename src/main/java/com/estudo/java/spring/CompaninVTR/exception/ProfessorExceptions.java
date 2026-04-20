package com.estudo.java.spring.CompaninVTR.exception;

public class ProfessorExceptions extends Exception {

    private static final long serialVersionUID = -6681777147239341684L;

    public ProfessorExceptions() {
        super();
    }

    public ProfessorExceptions(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProfessorExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessorExceptions(String message) {
        super(message);
    }

    public ProfessorExceptions(Throwable cause) {
        super(cause);
    }

}