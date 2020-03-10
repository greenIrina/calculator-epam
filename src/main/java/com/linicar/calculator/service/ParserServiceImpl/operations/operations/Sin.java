package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Sin extends AbstractUnaryOperator {
    public Sin(Expression x) {
        super(x);
    }

    protected Double apply(Double x) {
        return new DoubleOperations().sin(x);
    }
}
