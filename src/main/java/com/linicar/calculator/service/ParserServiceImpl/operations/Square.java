package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.SimpleOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Square<T> extends AbstractUnaryOperator<T> {

    public Square(TripleExpression<T> x, SimpleOperations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.square(x);
    }
}
