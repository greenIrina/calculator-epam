package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.repository.ParserRepository.TripleExpression;
import com.linicar.calculator.repository.ParserRepository.ModeOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Negative<T> extends AbstractUnaryOperator<T> {

    public Negative(TripleExpression<T> x, ModeOperations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.negative(x);
    }
}