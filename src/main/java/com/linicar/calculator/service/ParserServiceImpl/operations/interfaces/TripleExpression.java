package com.linicar.calculator.service.ParserServiceImpl.operations.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;

public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws EvaluatingExceptions, UnsupportedModeException, NotIntegerFactorialException;
}