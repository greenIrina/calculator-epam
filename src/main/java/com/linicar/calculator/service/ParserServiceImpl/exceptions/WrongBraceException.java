package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class WrongBraceException extends ParserException {

    public WrongBraceException(String type, String str, int ind) {
        super("No pair for " + type + " brace, index: " + ind + '\n' + pointError(str));
    }
}
