package com.linicar.calculator.parser.expression;

import com.linicar.calculator.parser.expression.exceptions.OverflowException;

public class CheckedSubtract extends AbstractBinaryOperation {
    public CheckedSubtract(final TripleExpression l, final TripleExpression r) {
        super(l, r);
    }

    protected void check(final int x, final int y) throws OverflowException {
        if (x >= 0 && y < 0 && x - Integer.MAX_VALUE > y) {
            throw new OverflowException();
        }
        if (x <= 0 && y > 0 && Integer.MIN_VALUE - x > -y) {
            throw new OverflowException();
        }
    }

    protected int f(final int x, final int y) throws OverflowException {
        check(x, y);
        return x - y;
    }
}
