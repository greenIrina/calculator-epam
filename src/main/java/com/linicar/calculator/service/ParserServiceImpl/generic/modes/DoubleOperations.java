package com.linicar.calculator.service.ParserServiceImpl.generic.modes;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.SimpleOperations;


public class DoubleOperations implements SimpleOperations<Double> {
    @Override
    public Double parseConst(String expression) throws ParserException {
        try {
            return Double.parseDouble(expression);
        } catch (NumberFormatException ex) {
            throw new IllegalConstException("double", expression);
        }
    }

    @Override
    public Double add(Double left, Double right) {
        return left + right;
    }

    @Override
    public Double sub(Double left, Double right) {
        return left - right;
    }

    @Override
    public Double divide(Double left, Double right) {
        return left / right;
    }

    @Override
    public Double mult(Double left, Double right) {
        return left * right;
    }

    @Override
    public Double negative(Double x) {
        return -x;
    }

    @Override
    public Double getNumber(int x) {
        return (double) x;
    }

    @Override
    public Double abs(Double x) throws OverflowException {
        if (x == Double.MIN_VALUE) {
            throw new OverflowException();
        }
        return Math.abs(x);
    }

    @Override
    public Double square(Double x) throws OverflowException {
        if (Math.abs(x) > Math.sqrt(Double.MAX_VALUE)) {
            throw new OverflowException();
        }
        return x * x;
    }

    @Override
    public Double mod(Double left, Double right) throws DivisionByZeroException {
        if (right == 0) {
            throw new DivisionByZeroException();
        }
        return left % right;
    }

    @Override
    public Double sqrt(Double x) throws EvaluatingExceptions {
        return Math.sqrt(x);
    }

    @Override
    public Double sin(Double x) throws EvaluatingExceptions {
        return Math.sin(x);
    }
    @Override
    public Double cos(Double x) throws EvaluatingExceptions {
        return Math.cos(x);
    }
    @Override
    public Double tan(Double x) throws EvaluatingExceptions {
        return Math.tan(x);
    }
    @Override
    public Double atan(Double x) throws EvaluatingExceptions {
        return Math.atan(x);
    }

}
