package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.ExpressionParser;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.BigDecimalOperations;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EngineeringCalcService implements ParserRepository {

    private final ExpressionParser parser;

    public EngineeringCalcService() {
        parser = new ExpressionParser(new BigDecimalOperations());
    }

    @Override
    public String evaluate(String expression) throws ParserException, EvaluatingExceptions {
        BigDecimal[] arguments = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        expression = expression.toLowerCase();

        if (expression.contains("where")) {
            arguments = getArguments(expression.substring(expression.indexOf("where")));
        }

        TripleExpression tripleExpression = parser.parse(expression);
        return (String) tripleExpression.evaluate(arguments[0], arguments[1], arguments[2]);
    }

    private BigDecimal[] getArguments(String expression) throws ParserException {
        BigDecimal[] arguments = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};

        return arguments;
    }

}