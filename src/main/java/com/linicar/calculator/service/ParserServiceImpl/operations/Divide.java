package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.ModeOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Divide<T> extends AbstractBinaryOperator<T> {

    public Divide(TripleExpression<T> x, TripleExpression<T> y, ModeOperations<T> mode) {
        super(x, y, mode);
    }

    protected T apply(T x, T y) throws EvaluatingExceptions {
        return mode.divide(x, y);
    }
}
