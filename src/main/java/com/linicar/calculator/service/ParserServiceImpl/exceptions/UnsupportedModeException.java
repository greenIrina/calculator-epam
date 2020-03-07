package com.linicar.calculator.service.ParserServiceImpl.exceptions;

public class UnsupportedModeException extends ParserException {
    public UnsupportedModeException(String mode) {
        super("HZ" + mode);
    }
}
