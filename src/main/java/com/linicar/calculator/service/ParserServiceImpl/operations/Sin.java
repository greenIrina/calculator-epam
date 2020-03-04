package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.SimpleOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;


public class Sin<T> extends AbstractUnaryOperator<T> {
    public Sin(TripleExpression<T> x, SimpleOperations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.abs(x);
    }
}
