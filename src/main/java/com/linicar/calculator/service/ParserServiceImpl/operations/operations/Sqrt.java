package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Sqrt<T> extends AbstractUnaryOperator<T> {

    public Sqrt(TripleExpression<T> x, Operations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.sqrt(x);
    }
}
