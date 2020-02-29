package com.linicar.calculator.parser.expression.exceptions;

public class UnknownOpException extends ParsingException {
    public UnknownOpException(final String id, final int ind) {
        super(String.format("Unknown identifier '%s' at position: %d", id, ind));
    }
}
