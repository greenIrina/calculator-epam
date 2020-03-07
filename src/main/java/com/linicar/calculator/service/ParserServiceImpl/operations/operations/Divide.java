package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Divide extends AbstractBinaryOperator {

    public Divide(TripleExpression x, TripleExpression y, Operations mode) {
        super(x, y, mode);
    }

    protected Double apply(Double x, Double y) throws EvaluatingExceptions {
        return mode.divide(x, y);
    }
}
