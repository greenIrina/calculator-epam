package com.linicar.calculator.parser.expression.exceptions;


public class IllegalConstantException extends ParsingException {
    public IllegalConstantException(final String reason, final int ind) {
        super(String.format("Constant %s is not okay at position: %d", reason, ind));
    }
}
