package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class MissedArgumentException extends ParserException {

    public MissedArgumentException(String pos, String str, int ind) {
        super("Missed " + pos + " argument on the position " + ind + '\n' + pointError(str));
    }
}