package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class ParserException extends Exception {
    ParserException(final String message) {
        super(message);
    }

    static String pointError(final String expr) {
        return expr + '\n' + "*".repeat(expr.length());
    }
}
