package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;

public interface Operations<T> {
    //Simple and Engineering operation
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


    //Engineering operation

    T factorial(T x) throws EvaluatingExceptions;

    T sin(T x) throws EvaluatingExceptions;

    T cos(T x) throws EvaluatingExceptions;

    T tan(T x) throws EvaluatingExceptions;

    T atan(T x) throws EvaluatingExceptions;

    T pow(T x, T y) throws EvaluatingExceptions;

    T log(T x, T y) throws EvaluatingExceptions;
}
