package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class MissedOperatorException extends ParserException {

    public MissedOperatorException(String str, int ind) {
        super("Missed " + str + " argument on the position " + ind + '\n' + pointError(str));
    }
}
