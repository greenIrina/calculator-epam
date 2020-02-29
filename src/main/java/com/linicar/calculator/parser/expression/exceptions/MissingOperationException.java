package com.linicar.calculator.parser.expression.exceptions;


public class MissingOperationException extends ParsingException {
    public MissingOperationException(final int ind) {
        super("Missing operation before position: " + ind);
    }
}
