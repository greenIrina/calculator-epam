package com.linicar.calculator.parser.expression;


public class High extends AbstractUnaryOperation {
    public High(final TripleExpression val) {
        this.val = val;
    }

    protected int f(final int x) {
        return Integer.highestOneBit(x);
    }
}
