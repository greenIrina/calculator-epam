package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.DoubleOperations;
import com.linicar.calculator.service.ParserServiceImpl.parser.ExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalcService implements ParserRepository {
    private final ExpressionParser parser;

    public SimpleCalcService() {
        parser = new ExpressionParser(new DoubleOperations());
    }

    @Override
    public Double evaluate(String expr) throws ParserException, EvaluatingExceptions {
        Expression expression = parser.parse(expr);
        return expression.evaluate();
    }
}
