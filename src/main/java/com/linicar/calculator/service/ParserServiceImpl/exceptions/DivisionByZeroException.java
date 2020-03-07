package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class DivisionByZeroException extends EvaluatingExceptions {
    public DivisionByZeroException() {
        super("division by zero");
    }
}
