package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.ModeOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Multiply<T> extends AbstractBinaryOperator<T> {

    public Multiply(TripleExpression<T> x, TripleExpression<T> y, ModeOperations<T> mode) {
        super(x, y, mode);
    }

    protected T apply(T x, T y) throws EvaluatingExceptions {
        return mode.mult(x, y);
    }
}
