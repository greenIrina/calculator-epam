package com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public abstract class AbstractUnaryOperator<T> implements TripleExpression<T> {
    protected final TripleExpression<T> operand;
    protected final Operations<T> mode;

    protected AbstractUnaryOperator(TripleExpression<T> operand, Operations<T> mode) {
        this.operand = operand;
        this.mode = mode;
    }

    protected abstract T apply(T x) throws EvaluatingExceptions, NotIntegerFactorialException;

    public T evaluate(T x, T y, T z) throws EvaluatingExceptions, UnsupportedModeException, NotIntegerFactorialException {
        return apply(operand.evaluate(x, y, z));
    }

}
