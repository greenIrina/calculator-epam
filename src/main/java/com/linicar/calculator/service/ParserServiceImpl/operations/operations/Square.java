package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Square extends AbstractUnaryOperator {

    public Square(TripleExpression x) {
        super(x);
    }

    protected Double apply(Double x) {
        return new DoubleOperations().square(x);
    }
}
