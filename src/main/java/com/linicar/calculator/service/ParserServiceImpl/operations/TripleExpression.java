package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;

public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws EvaluatingExceptions;
}