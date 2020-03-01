package com.linicar.calculator.parser.expression.exceptions;

import com.linicar.calculator.parser.expression.TripleExpression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser {
    TripleExpression parse(String expression) throws ParsingException;
}
