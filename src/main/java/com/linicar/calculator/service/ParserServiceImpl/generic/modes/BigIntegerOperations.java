package com.linicar.calculator.service.ParserServiceImpl.generic.modes;

import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.*;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

import java.math.BigInteger;


public class BigIntegerOperations implements SimpleOperations<BigInteger> {

    @Override
    public BigInteger parseConst(String expression) throws ParserException {
        try {
            return new BigInteger(expression);
        } catch (NumberFormatException ex) {
            throw new IllegalConstException("int", expression);
        }
    }

    @Override
    public BigInteger add(BigInteger left, BigInteger right) {
        return left.add(right);
    }

    @Override
    public BigInteger sub(BigInteger left, BigInteger right) {
        return left.subtract(right);
    }

    @Override
    public BigInteger divide(BigInteger left, BigInteger right)throws DivisionByZeroException {
        if(right.equals(BigInteger.ZERO)){
            throw new DivisionByZeroException();
        }
        return left.divide(right);
    }

    @Override
    public BigInteger mult(BigInteger left, BigInteger right) {
        return left.multiply(right);
    }

    public BigInteger negative(BigInteger x) {
        return x.negate();
    }

    @Override
    public BigInteger getNumber(int x) {
        return new BigInteger(Integer.toString(x));
    }

    @Override
    public BigInteger abs(BigInteger x){
       return x.abs();
    }

    @Override
    public BigInteger square(BigInteger x) {
        return x.multiply(x);
    }

    @Override
    public BigInteger mod(BigInteger left, BigInteger right) throws DivisionByZeroException {
        if (right.equals(BigInteger.ZERO)) {
            throw new DivisionByZeroException();
        }
        return left.mod(right);
    }
}
