package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class ConstOverflowException extends ParserException {
    public ConstOverflowException(String str) {
        super("Constant overflow, value: " + str);
    }
}
