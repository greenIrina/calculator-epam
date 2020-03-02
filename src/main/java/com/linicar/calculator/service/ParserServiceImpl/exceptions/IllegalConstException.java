package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class IllegalConstException extends ParserException {
    public IllegalConstException(String mode, String expression){
        super("Can't convert " + expression +" in " + mode);
    }
}
