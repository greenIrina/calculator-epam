package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.parser.ExpressionParser;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.DoubleOperations;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalcService implements ParserRepository<Double> {
    private final ExpressionParser<Double> parser;

    public SimpleCalcService() {
        parser = new ExpressionParser<>(new DoubleOperations());
    }

    @Override
    public Double evaluate(String expression) throws ParserException, EvaluatingExceptions {
        TripleExpression<Double> tripleExpression = parser.parse(expression);
        return tripleExpression.evaluate(0.0, 0.0, 0.0);
    }
}
