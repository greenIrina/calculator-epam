package com.linicar.calculator.parser.expression.exceptions;


public class MissingClosingParenthesisException extends ParsingException {
    public MissingClosingParenthesisException(final int ind) {
        super("Missing closing parenthesis for opening parenthesis at position: " + ind);
    }
}
