package com.linicar.calculator.parser.expression.exceptions;


public class OverflowException extends EvaluatingException {
    public OverflowException() {
        super("overflow");
    }
}
