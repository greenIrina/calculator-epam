package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public class Variable implements TripleExpression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public Double evaluate(Double x, Double y, Double z) {
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
