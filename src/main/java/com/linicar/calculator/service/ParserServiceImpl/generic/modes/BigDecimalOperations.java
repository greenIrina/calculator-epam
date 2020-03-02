package com.linicar.calculator.service.ParserServiceImpl.generic.modes;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.*;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalOperations implements ModeOperations<BigDecimal> {

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
}
