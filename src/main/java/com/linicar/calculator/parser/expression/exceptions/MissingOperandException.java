package com.linicar.calculator.parser.expression.exceptions;


public class MissingOperandException extends ParsingException {
    public MissingOperandException(final int ind) {
        super("Missing operand before position: " + ind);
    }
}
