package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.DoubleOperations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.parser.ExpressionParser;
import org.springframework.stereotype.Service;


@Service
public class EngineeringCalcService implements ParserRepository {

    private final ExpressionParser parser;

    public EngineeringCalcService() {
        parser = new ExpressionParser(new DoubleOperations());
    }

    @Override
    public Double evaluate(String expression) throws ParserException, EvaluatingExceptions {
        Double[] arguments = {0.0, 0.0, 0.0};
        expression = expression.toLowerCase();
        expression = expression.trim();

        return evaluate(expression, arguments[0], arguments[1], arguments[2]);
    }

    private Double evaluate(String expression, Double x, Double y, Double z) throws ParserException, EvaluatingExceptions {
        TripleExpression tripleExpression = parser.parse(expression);
        return tripleExpression.evaluate(x, y, z);
    }

}
