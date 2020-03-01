package com.linicar.calculator.repository.ParserRepository;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;

public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParserException;
}