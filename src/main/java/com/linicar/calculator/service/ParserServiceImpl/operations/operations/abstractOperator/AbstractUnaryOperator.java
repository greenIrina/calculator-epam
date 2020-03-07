package com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator;

import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public abstract class AbstractUnaryOperator implements TripleExpression {
    protected final TripleExpression operand;
    protected final Operations mode;

    protected AbstractUnaryOperator(TripleExpression operand, Operations mode) {
        this.operand = operand;
        this.mode = mode;
    }

    protected abstract Double apply(Double x) throws EvaluatingExceptions, NotIntegerFactorialException;

    public Double evaluate(Double x, Double y, Double z) throws EvaluatingExceptions, UnsupportedModeException, NotIntegerFactorialException {
        return apply(operand.evaluate(x, y, z));
    }

}
