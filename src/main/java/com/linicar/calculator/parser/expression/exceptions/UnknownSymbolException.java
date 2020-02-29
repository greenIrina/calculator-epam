package com.linicar.calculator.parser.expression.exceptions;

public class UnknownSymbolException extends ParsingException {
    public UnknownSymbolException(final String s, final int ind) {
        super(String.format("Unknown symbol '%s' at position: %d", s.charAt(ind), ind));
    }
}
