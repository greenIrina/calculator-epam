package com.linicar.calculator.service.ParserServiceImpl.generic.modes;


import com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces.*;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;


public class IntegerOperations implements ModeOperations<Integer> {
    @Override
    public Integer parseConst(String expression) throws ParserException {
        try {
            return Integer.parseInt(expression);
        } catch (NumberFormatException ex) {
            throw new IllegalConstException("int", expression);
        }
    }

    @Override
    public Integer add(Integer left, Integer right) throws OverflowException {
        if (left > 0 && Integer.MAX_VALUE - left < right
                || left < 0 && Integer.MIN_VALUE - left > right) {
            throw new OverflowException();
        }
        return left + right;
    }

    @Override
    public Integer sub(Integer left, Integer right) throws OverflowException {
        if (left >= 0 && right < 0 && left - Integer.MAX_VALUE > right
                || left <= 0 && right > 0 && Integer.MIN_VALUE - left > -right) {
            throw new OverflowException();
        }

        return left - right;
    }

    @Override
    public Integer divide(Integer left, Integer right) throws OverflowException, DivisionByZeroException {
        if (right == 0) {
            throw new DivisionByZeroException();
        }
        if (left == Integer.MIN_VALUE && right == -1) {
            throw new OverflowException();
        }
        return left / right;
    }

    @Override
    public Integer mult(Integer left, Integer right) throws OverflowException {
        if (left > 0 && right > 0 && Integer.MAX_VALUE / left < right ||
                left > 0 && right < 0 && Integer.MIN_VALUE / left > right ||
                left < 0 && right > 0 && Integer.MIN_VALUE / right > left ||
                left < 0 && right < 0 && Integer.MAX_VALUE / left > right) {
            throw new OverflowException();
        }
        return left * right;
    }

    public Integer negative(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -x;
    }

    @Override
    public Integer getNumber(int x) {
        return x;
    }

    @Override
    public Integer abs(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return Math.abs(x);
    }

    @Override
    public Integer square(Integer x) throws OverflowException {
        if (Math.abs(x) > Math.sqrt(Integer.MAX_VALUE)) {
            throw new OverflowException();
        }
        return x * x;
    }

    @Override
    public Integer mod(Integer left, Integer right) throws DivisionByZeroException {
        if (right == 0) {
            throw new DivisionByZeroException();
        }
        return left % right;
    }
}
