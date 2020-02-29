package com.linicar.calculator.parser.expression;

import expression.exceptions.EvaluatingException;

public abstract class AbstractBinaryOperation implements TripleExpression {
    private TripleExpression l;
    private TripleExpression r;

    AbstractBinaryOperation(TripleExpression l, TripleExpression r) {
        this.l = l;
        this.r = r;
    }

    protected abstract int f(int x, int y) throws EvaluatingException;

    protected abstract void check(int x, int y) throws EvaluatingException;

    public int evaluate(int x, int y, int z) throws EvaluatingException {
        return f(l.evaluate(x, y, z), r.evaluate(x, y, z));
    }
}
