package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Add extends AbstractBinaryOperator {

    public Add(Expression x, Expression y) {
        super(x, y);
    }

    protected Double apply(Double x, Double y) {
        return new DoubleOperations().add(x, y);
    }
}
