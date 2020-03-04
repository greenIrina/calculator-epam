package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public class Square<T> extends AbstractUnaryOperator<T> {

    public Square(TripleExpression<T> x, Operations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.square(x);
    }
}
