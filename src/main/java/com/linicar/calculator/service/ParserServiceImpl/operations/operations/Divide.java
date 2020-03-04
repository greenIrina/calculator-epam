package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.SimpleOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public class Divide<T> extends AbstractBinaryOperator<T> {

    public Divide(TripleExpression<T> x, TripleExpression<T> y, Operations<T> mode) {
        super(x, y, mode);
    }

    protected T apply(T x, T y) throws EvaluatingExceptions {
        return mode.divide(x, y);
    }
}
