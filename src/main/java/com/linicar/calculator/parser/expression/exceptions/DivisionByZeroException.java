package com.linicar.calculator.parser.expression.exceptions;

public class DivisionByZeroException extends IllegalOperationException {
    public DivisionByZeroException() {
        super("Division by zero");
    }
}
