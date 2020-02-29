package com.linicar.calculator.parser.expression;

public class Low extends AbstractUnaryOperation {
    public Low(final TripleExpression val) {
        this.val = val;
    }

    protected int f(final int x) {
        return Integer.lowestOneBit(x);
    }
}
