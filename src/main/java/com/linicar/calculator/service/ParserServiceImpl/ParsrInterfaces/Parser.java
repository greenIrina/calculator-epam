package com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;

public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParserException;
}