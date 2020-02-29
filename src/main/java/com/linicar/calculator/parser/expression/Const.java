package com.linicar.calculator.parser.expression;

public class Const implements TripleExpression {
    private final Number value;

    public Const(final int x) {
        value = x;
    }

    public int evaluate(final int x, final int y, final int z) {
        return value.intValue();
    }
}
