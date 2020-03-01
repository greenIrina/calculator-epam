package com.linicar.calculator.parser.expression;

import com.linicar.calculator.parser.expression.exceptions.DivisionByZeroException;
import com.linicar.calculator.parser.expression.exceptions.IllegalOperationException;
import com.linicar.calculator.parser.expression.exceptions.OverflowException;

public class CheckedDivide extends AbstractBinaryOperation {
    public CheckedDivide(final TripleExpression l, final TripleExpression r) {
        super(l, r);
    }

    protected void check(final int x, final int y) throws IllegalOperationException, OverflowException {
        if (y == 0) {
            throw new DivisionByZeroException();
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new OverflowException();
        }
    }

    protected int f(final int x, final int y) throws IllegalOperationException, OverflowException {
        check(x, y);
        return x / y;
    }
}
