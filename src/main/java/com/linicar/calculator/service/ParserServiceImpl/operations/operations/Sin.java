package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.DoubleOperations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Sin extends AbstractUnaryOperator {
    public Sin(TripleExpression x) {
        super(x);
    }

    protected Double apply(Double x){
        return new DoubleOperations().sin(x);
    }
}
