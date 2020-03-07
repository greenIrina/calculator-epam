package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Factorial extends AbstractUnaryOperator {

    public Factorial(TripleExpression operand, Operations mode) {
        super(operand, mode);
    }

    @Override
    protected Double apply(Double x) throws EvaluatingExceptions, NotIntegerFactorialException {
        return mode.factorial(x);
    }
}
