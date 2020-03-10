package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator.AbstractUnaryOperator;

public class Factorial extends AbstractUnaryOperator {

    public Factorial(Expression operand) {
        super(operand);
    }

    @Override
    protected Double apply(Double x) throws EvaluatingExceptions {
        return new DoubleOperations().factorial(x);
    }
}
