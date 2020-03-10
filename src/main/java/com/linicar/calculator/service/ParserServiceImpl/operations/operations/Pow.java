package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Pow extends AbstractBinaryOperator {

    public Pow(Expression x, Expression y) {
        super(x, y);
    }

    protected Double apply(Double x, Double y) {
        return new DoubleOperations().pow(x, y);
    }
}
