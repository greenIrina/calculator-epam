package com.linicar.calculator.service.ParserServiceImpl.parser;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public interface Parser {
    TripleExpression parse(String expression) throws ParserException;
}