package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Pow extends AbstractBinaryOperator {

    public Pow(TripleExpression x, TripleExpression y, Operations mode) {
        super(x, y, mode);
    }

    protected Double apply(Double x, Double y) throws EvaluatingExceptions {
        return mode.pow(x, y);
    }
}
