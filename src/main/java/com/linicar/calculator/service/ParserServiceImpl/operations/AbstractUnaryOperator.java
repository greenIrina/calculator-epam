package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.ModeOperations;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public abstract class AbstractUnaryOperator<T> implements TripleExpression<T> {
    protected final TripleExpression<T> operand;
    protected final ModeOperations<T> mode;

    protected AbstractUnaryOperator(TripleExpression<T> operand, ModeOperations<T> mode) {
        this.operand = operand;
        this.mode = mode;
    }

    protected abstract T apply(T x) throws EvaluatingExceptions;

    public T evaluate(T x, T y, T z) throws EvaluatingExceptions {
        return apply(operand.evaluate(x, y, z));
    }

}