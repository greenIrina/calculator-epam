package com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;

public abstract class AbstractBinaryOperator implements Expression {
    private Expression firstOperand;
    private Expression secondOperand;

    protected AbstractBinaryOperator(Expression x, Expression y) {
        firstOperand = x;
        secondOperand = y;
    }

    protected abstract Double apply(Double x, Double y) throws EvaluatingExceptions, UnsupportedModeException;

    public Double evaluate() throws EvaluatingExceptions, UnsupportedModeException {
        return apply(firstOperand.evaluate(), secondOperand.evaluate());
    }
}
