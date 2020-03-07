package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Abs extends AbstractUnaryOperator {

    public Abs(TripleExpression x) {
        super(x);
    }

    protected Double apply(Double x) {
        return new DoubleOperations().abs(x);
    }
}
