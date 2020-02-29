package com.linicar.calculator.parser.expression;

import expression.exceptions.OverflowException;

public class CheckedNegate extends AbstractUnaryOperation {
    public CheckedNegate(final TripleExpression val) {
        this.val = val;
    }

    protected void check(final int x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
    }

    protected int f(final int x) throws OverflowException {
        check(x);
        return -x;
    }
}
