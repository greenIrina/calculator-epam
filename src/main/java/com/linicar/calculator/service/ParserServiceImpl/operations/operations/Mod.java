package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Mod extends AbstractBinaryOperator {

    public Mod(TripleExpression x, TripleExpression y) {
        super(x, y);
    }

    protected Double apply(Double x, Double y) {
        return new DoubleOperations().mod(x, y);
    }
}
