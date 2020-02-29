package com.linicar.calculator.parser.expression;

public class Variable implements TripleExpression {
    private final char variableName;

    public Variable(final String x) {
        variableName = x.charAt(0);
    }

    public int evaluate(final int x, final int y, final int z) {
        switch (variableName) {
            case 'x':
                return x;
            case 'y':
                return y;
            case 'z':
                return z;
            default:
                return 0;
        }
    }
}
