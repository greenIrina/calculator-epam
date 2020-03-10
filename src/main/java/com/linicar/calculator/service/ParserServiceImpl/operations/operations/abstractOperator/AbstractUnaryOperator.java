package com.linicar.calculator.service.ParserServiceImpl.operations.operations.abstractOperator;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;

public abstract class AbstractUnaryOperator implements Expression {
    protected final Expression operand;

    protected AbstractUnaryOperator(Expression operand) {
        this.operand = operand;
    }

    protected abstract Double apply(Double x) throws EvaluatingExceptions;

    public Double evaluate() throws EvaluatingExceptions, UnsupportedModeException {
        return apply(operand.evaluate());
    }

}
