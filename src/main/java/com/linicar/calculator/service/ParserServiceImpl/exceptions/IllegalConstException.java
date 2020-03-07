package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class IllegalConstException extends ParserException {
    public IllegalConstException(String expression){
        super("Can't parse constant " + expression);
    }
}
