package com.linicar.calculator.service.ParserServiceImpl.generic.modes;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.IllegalArgumentException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;


public class DoubleOperations implements Operations {
    @Override
    public Double parseConst(String expression) throws ParserException {
        try {
            return Double.parseDouble(expression);
        } catch (NumberFormatException ex) {
            throw new IllegalConstException(expression);
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
    public Double getNumber(Double x) {
        return x;
    }

    @Override
    public Double abs(Double x) {
        return Math.abs(x);
    }

    @Override
    public Double square(Double x) {
        return x * x;
    }

    @Override
    public Double mod(Double left, Double right) {
        return left % right;
    }

    @Override
    public Double sqrt(Double x) {
        return Math.sqrt(x);
    }

    @Override
    public Double factorial(Double x) throws EvaluatingExceptions {
        return factorialFinder(x);
    }

    @Override
    public Double sin(Double x) {
        return Math.sin(x);
    }

    @Override
    public Double cos(Double x) {
        return Math.cos(x);
    }

    @Override
    public Double tan(Double x) {
        return Math.tan(x);
    }

    @Override
    public Double atan(Double x) {
        return Math.atan(x);
    }

    @Override
    public Double pow(Double x, Double y) {
        return Math.pow(x, y);
    }

    @Override
    public Double log(Double x, Double y) throws IllegalArgumentException {
        if (x < 0 || x == 1 || y < 0) {
            throw new IllegalArgumentException("Error: Illegal argument for logarithm function");
        }
        return Math.log(y) / Math.log(x);
    }

    private Double factorialFinder(Double x) throws NotIntegerFactorialException {
        int ans = 1, cnt = 1;
        if (x == Math.floor(x)) {
            while (cnt <= x) {
                ans *= cnt++;
                if (ans < 0) {
                    return Double.POSITIVE_INFINITY;
                }
            }
            return (double) ans;
        } else {
            throw new NotIntegerFactorialException("Can't find factorial of non-integer value " + x.toString());
        }
    }
}
