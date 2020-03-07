package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.TripleExpression;

public class Const implements TripleExpression {

    private final Double number;

    public Const(Double number) {
        this.number = number;
    }

    public Double evaluate(Double x, Double y, Double z) {
        return number;
    }
}
