package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.DoubleOperations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Multiply extends AbstractBinaryOperator {

    public Multiply(TripleExpression x, TripleExpression y) {
        super(x, y);
    }

    protected Double apply(Double x, Double y) {
        return new DoubleOperations().mult(x, y);
    }
}
