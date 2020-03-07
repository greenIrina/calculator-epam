package com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public abstract class AbstractBinaryOperator implements TripleExpression {
    private TripleExpression firstOperand;
    private TripleExpression secondOperand;

    protected AbstractBinaryOperator(TripleExpression x, TripleExpression y) {
        firstOperand = x;
        secondOperand = y;
    }

    protected abstract Double apply(Double x, Double y) throws EvaluatingExceptions, UnsupportedModeException;

    public Double evaluate(Double x, Double y, Double z) throws EvaluatingExceptions, UnsupportedModeException, NotIntegerFactorialException {
        return apply(firstOperand.evaluate(x, y, z), secondOperand.evaluate(x, y, z));
    }
}
