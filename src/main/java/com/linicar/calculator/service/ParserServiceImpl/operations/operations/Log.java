package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractBinaryOperator;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Log extends AbstractBinaryOperator {

    public Log(TripleExpression x, TripleExpression y, Operations mode) {
        super(x, y, mode);
    }

    protected Double apply(Double x, Double y) throws EvaluatingExceptions, UnsupportedModeException {
        return mode.log(x, y);
    }
}
