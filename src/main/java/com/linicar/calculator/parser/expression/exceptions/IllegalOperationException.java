package com.linicar.calculator.parser.expression.exceptions;


public class IllegalOperationException extends EvaluatingException {
    public IllegalOperationException(final String message) {
        super("Illegal operation: " + message);
    }
}
