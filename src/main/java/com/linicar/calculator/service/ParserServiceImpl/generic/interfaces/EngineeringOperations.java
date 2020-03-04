package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;


public interface EngineeringOperations<T> extends SimpleOperations<T> {

    T sin(T x) throws EvaluatingExceptions;

    T cos(T x) throws EvaluatingExceptions;

    T tan(T x) throws EvaluatingExceptions;

    T atan(T x) throws EvaluatingExceptions;

    T pow(T x, T y) throws EvaluatingExceptions;

}
