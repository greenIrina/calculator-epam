package com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.SimpleOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public abstract class AbstractBinaryOperator<T> implements TripleExpression<T> {
    private TripleExpression<T> firstOperand;
    private TripleExpression<T> secondOperand;
    protected Operations<T> mode;

    protected AbstractBinaryOperator(TripleExpression<T> x, TripleExpression<T> y, Operations<T> mode) {
        firstOperand = x;
        secondOperand = y;
        this.mode = mode;
    }

    protected abstract T apply(T x, T y) throws EvaluatingExceptions, UnsupportedModeException;

    public T evaluate(T x, T y, T z) throws EvaluatingExceptions, UnsupportedModeException, NotIntegerFactorialException {
        return apply(firstOperand.evaluate(x, y, z), secondOperand.evaluate(x, y, z));
    }
}
