package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public interface SimpleOperations<T> extends Operations<T> {

    default T pow(T x, T y) throws EvaluatingExceptions, UnsupportedModeException {
        throw new UnsupportedModeException("");
    }


}
