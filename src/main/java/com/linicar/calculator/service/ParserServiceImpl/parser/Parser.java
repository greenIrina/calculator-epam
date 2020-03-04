package com.linicar.calculator.service.ParserServiceImpl.parser;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.operations.TripleExpression;

public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParserException;
}