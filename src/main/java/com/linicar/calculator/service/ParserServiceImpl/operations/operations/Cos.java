package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Cos extends AbstractUnaryOperator {
    public Cos(TripleExpression x, Operations mode) {
        super(x, mode);
    }

    protected Double apply(Double x) throws EvaluatingExceptions {
        return mode.cos(x);
    }
}
