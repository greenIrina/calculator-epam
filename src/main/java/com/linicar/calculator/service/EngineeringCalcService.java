package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.ExpressionParser;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.BigDecimalOperations;


public class EngineeringCalcService implements ParserRepository {

    private final ExpressionParser parser;

    public EngineeringCalcService() {
        parser = new ExpressionParser(new BigDecimalOperations());
    }

    @Override
    public Double evaluate(String expression) throws ParserException, EvaluatingExceptions {
        TripleExpression tripleExpression = parser.parse(expression);
        return (Double) tripleExpression.evaluate(0, 0, 0);
    }


}