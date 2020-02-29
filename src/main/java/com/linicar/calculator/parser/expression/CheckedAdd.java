package com.linicar.calculator.parser.expression;

import expression.exceptions.OverflowException;

public class CheckedAdd extends AbstractBinaryOperation {
    public CheckedAdd(final TripleExpression l, final TripleExpression r) {
        super(l, r);
    }

    protected void check(final int x, final int y) throws OverflowException {
        if (x > 0 && Integer.MAX_VALUE - x < y ||
                x < 0 && Integer.MIN_VALUE - x > y) {
            throw new OverflowException();
        }
    }

    protected int f(final int x, final int y) throws OverflowException {
        check(x, y);
        return x + y;
    }
}
