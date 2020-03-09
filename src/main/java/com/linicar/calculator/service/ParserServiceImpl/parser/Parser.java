package com.linicar.calculator.service.ParserServiceImpl.parser;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;

public interface Parser {
    Expression parse(String expression) throws ParserException;
}
