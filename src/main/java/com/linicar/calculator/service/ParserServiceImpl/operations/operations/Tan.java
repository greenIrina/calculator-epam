package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Tan extends AbstractUnaryOperator {

    public Tan(TripleExpression x) {
        super(x);
    }

    protected Double apply(Double x) {
        return new DoubleOperations().tan(x);
    }
}
