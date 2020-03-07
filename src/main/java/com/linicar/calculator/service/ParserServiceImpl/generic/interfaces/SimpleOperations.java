package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public interface SimpleOperations<T> extends Operations<T> {

    default T pow(T x, T y) throws EvaluatingExceptions {
        throw new EvaluatingExceptions("Error: operation ^ not supported in simple calc.");
    }

    default T log(T x, T y) throws EvaluatingExceptions {
        throw new EvaluatingExceptions("Error: function log(b,a) not supported in simple calc.");
    }

}
