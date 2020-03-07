package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Factorial extends AbstractUnaryOperator {

    public Factorial(TripleExpression operand) {
        super(operand);
    }

    @Override
    protected Double apply(Double x) throws EvaluatingExceptions {
        return new DoubleOperations().factorial(x);
    }
}
