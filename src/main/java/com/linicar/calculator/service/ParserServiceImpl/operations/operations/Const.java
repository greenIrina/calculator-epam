package com.linicar.calculator.service.ParserServiceImpl.operations.operations;

import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;

public class Const implements Expression {

    private final Double number;

    public Const(Double number) {
        this.number = number;
    }

    public Double evaluate() {
        return number;
    }
}
