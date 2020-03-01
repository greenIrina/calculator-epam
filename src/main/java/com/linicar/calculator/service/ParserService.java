package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.ExpressionParser;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.*;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.*;

public class ParserService implements ParserRepository {

    private final ExpressionParser parser;

    public ParserService(String mode) throws UnsupportedModeException {
        parser = new ExpressionParser(getMode(mode));
    }

    public String evaluate(String expression) throws ParserException, EvaluatingExceptions {
        TripleExpression tripleExpression = parser.parse(expression);

        return (String) tripleExpression.evaluate(0, 0, 0);
    }

    private ModeOperations<?> getMode(String mode) throws UnsupportedModeException {
        switch (mode) {
            case "i":
                return new IntegerOperations();
            case "d":
                return new DoubleOperations();
            case "bi":
                return new BigIntegerOperations();
            default:
                throw new UnsupportedModeException(mode);
        }
    }

}
