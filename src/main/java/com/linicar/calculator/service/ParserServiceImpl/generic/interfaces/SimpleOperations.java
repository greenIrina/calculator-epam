package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public interface SimpleOperations<T> extends Operations<T>{

    default T sin(T x) throws EvaluatingExceptions, UnsupportedModeException {
        throw new UnsupportedModeException("Мы не поддерживаем это здесь");
    }

    default T cos(T x) throws EvaluatingExceptions, UnsupportedModeException {
        throw new UnsupportedModeException("");
    }

    default T tan(T x) throws EvaluatingExceptions, UnsupportedModeException{
        throw new UnsupportedModeException("");
    }

    default T atan(T x) throws EvaluatingExceptions, UnsupportedModeException{
        throw new UnsupportedModeException("");
    }

    default T pow(T x, T y) throws EvaluatingExceptions, UnsupportedModeException{
        throw new UnsupportedModeException("");
    }


}
