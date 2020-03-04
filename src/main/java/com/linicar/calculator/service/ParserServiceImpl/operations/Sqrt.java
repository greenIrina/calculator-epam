package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.SimpleOperations;

public class Sqrt<T> extends AbstractUnaryOperator<T> {

    public Sqrt(TripleExpression<T> x, SimpleOperations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.sqrt(x);
    }
}
