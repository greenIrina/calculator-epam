package com.linicar.calculator.parser.expression;

import expression.exceptions.EvaluatingException;

public abstract class AbstractUnaryOperation implements TripleExpression {
    TripleExpression val;

    protected abstract int f(int x) throws EvaluatingException;

    public int evaluate(int x, int y, int z) throws EvaluatingException {
        return f(val.evaluate(x, y, z));
    }
}
