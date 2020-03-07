package com.linicar.calculator.service.ParserServiceImpl.generic.modes;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.generic.interfaces.Operations;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalOperations implements Operations<BigDecimal> {

    //точность
    private static int precision = 10;
    private static MathContext mc = new MathContext(precision);

    @Override
    public BigDecimal parseConst(String expression) throws ParserException {
        try {
            return new BigDecimal(expression);
        } catch (NumberFormatException ex) {
            throw new IllegalConstException("int", expression);
        }
    }

    @Override
    public BigDecimal add(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

    @Override
    public BigDecimal sub(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    @Override
    public BigDecimal divide(BigDecimal left, BigDecimal right) throws DivisionByZeroException {
        if (right.equals(BigDecimal.ZERO)) {
            throw new DivisionByZeroException();
        }
        return left.divide(right);
    }

    @Override
    public BigDecimal mult(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }

    public BigDecimal negative(BigDecimal x) {
        return x.negate();
    }

    @Override
    public BigDecimal getNumber(int x) {
        return new BigDecimal(Integer.toString(x));
    }

    @Override
    public BigDecimal abs(BigDecimal x) {
        return x.abs();
    }

    @Override
    public BigDecimal square(BigDecimal x) {
        return x.multiply(x);
    }

    @Override
    public BigDecimal mod(BigDecimal left, BigDecimal right) throws DivisionByZeroException {
        if (right.equals(BigDecimal.ZERO)) {
            throw new DivisionByZeroException();
        }
        //todo: работает ли с отрицательными числами?
        return left.subtract(left.divide(right).multiply(right));
    }

    @Override
    public BigDecimal sqrt(BigDecimal x) throws EvaluatingExceptions {
        return x.sqrt(mc);
    }

    @Override
    public BigDecimal factorial(BigDecimal x) throws EvaluatingExceptions, NotIntegerFactorialException {
        return BigDecimal.valueOf(factorialFinder(x));
    }

    @Override
    public BigDecimal pow(BigDecimal x, BigDecimal y) throws EvaluatingExceptions {
        return BigDecimal.valueOf(Math.pow(x.doubleValue(), y.doubleValue()));
    }

    @Override
    public BigDecimal sin(BigDecimal x) throws EvaluatingExceptions {
        return BigDecimal.valueOf(Math.sin(x.doubleValue()));
    }

    @Override
    public BigDecimal cos(BigDecimal x) throws EvaluatingExceptions {
        return BigDecimal.valueOf(Math.cos(x.doubleValue()));
    }

    @Override
    public BigDecimal tan(BigDecimal x) throws EvaluatingExceptions {
        return BigDecimal.valueOf(Math.tan(x.doubleValue()));
    }

    @Override
    public BigDecimal atan(BigDecimal x) throws EvaluatingExceptions {
        return BigDecimal.valueOf(Math.atan(x.doubleValue()));
    }

    @Override
    public BigDecimal log(BigDecimal b, BigDecimal a) throws DivisionByZeroException {
        try {
            return BigDecimal.valueOf(Math.log(b.doubleValue()))
                    .divide(BigDecimal.valueOf(Math.log(a.doubleValue())), mc);
        } catch (ArithmeticException ex) {
            throw new DivisionByZeroException();
        }
    }

    private int factorialFinder(BigDecimal y) throws NotIntegerFactorialException {
        int ans = 1, cnt = 1;
        double x = y.doubleValue();//todo: почему даблы?
        if (x == Math.floor(x)) {
            while (cnt <= x) {
                ans *= cnt++;
            }
            return ans;
        } else {
            throw new NotIntegerFactorialException("Can't find factorial of non-integer value " + x);
        }
    }
}
