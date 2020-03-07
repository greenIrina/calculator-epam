package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;

public class Log extends AbstractBinaryOperator {

    public Log(TripleExpression x, TripleExpression y) {
        super(x, y);
    }

    protected Double apply(Double x, Double y) throws EvaluatingExceptions {
        return new DoubleOperations().log(x, y);
    }
}
