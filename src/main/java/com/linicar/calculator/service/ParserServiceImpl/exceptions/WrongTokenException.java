package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class WrongTokenException extends ParserException {

    public WrongTokenException(char ch, String expr) {
        super("Illegal token " + ch + " in expression " + expr);
    }

    public WrongTokenException(String s, String expr) {
        super("Illegal command or variable: " + s + " in expression " + expr);
    }
}
