package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public interface SimpleOperations<T> {
    T parseConst(String expression) throws ParserException;

    T add(T left, T right) throws EvaluatingExceptions;

    T sub(T left, T right) throws EvaluatingExceptions;

    T divide(T left, T right) throws EvaluatingExceptions;

    T mult(T left, T right) throws EvaluatingExceptions;

    T negative(T x) throws EvaluatingExceptions;

    T getNumber(int x);

    T abs(T x) throws EvaluatingExceptions;

    T square(T x) throws EvaluatingExceptions;

    T mod(T left, T right) throws EvaluatingExceptions;

    T sqrt(T x) throws EvaluatingExceptions;

}
