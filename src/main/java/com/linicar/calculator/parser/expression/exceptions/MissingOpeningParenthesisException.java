package com.linicar.calculator.parser.expression.exceptions;


public class MissingOpeningParenthesisException extends ParsingException {
    public MissingOpeningParenthesisException(int ind) {
        super("Closing parenthesis without an opening one at position: " + ind);
    }
}
