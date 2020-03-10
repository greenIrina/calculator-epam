package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class MissedArgumentException extends ParserException {

    public MissedArgumentException(String pos, String str) {
        super("Missed " + pos + " argument: " + pointError(str));
    }
}