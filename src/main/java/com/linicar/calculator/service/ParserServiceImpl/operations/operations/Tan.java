package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Tan extends AbstractUnaryOperator {

    public Tan(TripleExpression x, Operations mode) {
        super(x, mode);
    }

    protected Double apply(Double x) throws EvaluatingExceptions {
        return mode.tan(x);
    }
}
