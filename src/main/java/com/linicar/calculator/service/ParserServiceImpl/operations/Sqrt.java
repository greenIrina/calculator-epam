package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.EngineeringOperations;
import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Sqrt<T> extends AbstractUnaryOperator<T> {

    public Sqrt(TripleExpression<T> x, EngineeringOperations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.sqrt(x);
    }
}
