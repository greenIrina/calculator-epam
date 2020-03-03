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
    public BigDecimal evaluate(String expression) throws ParserException, EvaluatingExceptions {
        BigDecimal[] arguments = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        expression = expression.toLowerCase();
        expression = expression.trim();
        if (expression.contains("where")) {
            arguments = getArguments(expression.substring(expression.indexOf("where")));
        }
        return evaluate(expression, arguments[0], arguments[1], arguments[2]);
    }

    private BigDecimal evaluate(String expression, BigDecimal x, BigDecimal y, BigDecimal z) throws ParserException, EvaluatingExceptions {
        TripleExpression tripleExpression = parser.parse(expression);
        return (BigDecimal) tripleExpression.evaluate(x, y, z);
    }

    private BigDecimal[] getArguments(String expression) throws ParserException, EvaluatingExceptions {
        BigDecimal[] arguments = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        expression = expression.replaceAll("[\\s]{2,}", " ");
        String[] expr = expression.split(" ");
        for (String str : expr) {

            if (str.startsWith("x=") || str.startsWith("x =")) {
                arguments[0] = evaluate(str.substring(!str.contains("x=") ? str.indexOf("x =") :
                        str.indexOf("x=")), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
            } else if (str.startsWith("y=") || str.startsWith("y =")) {
                arguments[1] = evaluate(str.substring(!str.contains("y=") ? str.indexOf("y =") :
                        str.indexOf("x=")), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
            } else if (str.startsWith("z=") || str.startsWith("z =")) {
                arguments[1] = evaluate(str.substring(!str.contains("z=") ? str.indexOf("z =") :
                        str.indexOf("x=")), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
            }
        }
        return arguments;
    }

}