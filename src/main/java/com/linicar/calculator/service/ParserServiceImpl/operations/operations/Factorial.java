package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Factorial<T> extends AbstractUnaryOperator<T> {

    public Factorial(TripleExpression<T> operand, Operations<T> mode) {
        super(operand, mode);
    }

    @Override
    protected T apply(T x) throws EvaluatingExceptions, NotIntegerFactorialException {
        return mode.factorial(x);
    }
}
