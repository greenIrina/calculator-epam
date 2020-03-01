package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.repository.ParserRepository.TripleExpression;

public class Variable<T> implements TripleExpression<T> {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public T evaluate(T x, T y, T z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                return null;
        }

    }

}
