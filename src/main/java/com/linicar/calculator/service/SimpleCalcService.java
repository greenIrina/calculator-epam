package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.ExpressionParser;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.DoubleOperations;


public class SimpleCalcService implements ParserRepository {
    private final ExpressionParser parser;

    public SimpleCalcService() {
        parser = new ExpressionParser(new DoubleOperations());
    }

    @Override
    public String evaluate(String expression) throws ParserException, EvaluatingExceptions {
        TripleExpression tripleExpression = parser.parse(expression);
        return (String) tripleExpression.evaluate(0, 0, 0);
    }


}
