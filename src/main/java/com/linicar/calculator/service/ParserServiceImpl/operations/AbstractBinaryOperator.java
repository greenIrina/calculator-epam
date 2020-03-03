package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.SimpleOperations;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public abstract class AbstractBinaryOperator<T> implements TripleExpression<T> {
    private TripleExpression<T> firstOperand;
    private TripleExpression<T> secondOperand;
    protected SimpleOperations<T> mode;

    AbstractBinaryOperator(TripleExpression<T> x, TripleExpression<T> y, SimpleOperations<T> mode) {
        firstOperand = x;
        secondOperand = y;
        this.mode = mode;
    }

    protected abstract T apply(T x, T y) throws EvaluatingExceptions;

    public T evaluate(T x, T y, T z) throws EvaluatingExceptions {
        return apply(firstOperand.evaluate(x, y, z), secondOperand.evaluate(x, y, z));
    }
}
