package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.TripleExpression;

public class Const<T> implements TripleExpression<T> {

    private final T number;

    public Const(T number) {
        this.number = number;
    }

    public T evaluate(T x, T y, T z) {
        return number;
    }
}
