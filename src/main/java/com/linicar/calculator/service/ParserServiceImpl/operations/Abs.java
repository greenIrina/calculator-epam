package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.repository.ParserRepository.ModeOperations;
import com.linicar.calculator.repository.ParserRepository.TripleExpression;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Abs<T> extends AbstractUnaryOperator<T> {

    public Abs(TripleExpression<T> x, ModeOperations<T> mode) {
        super(x, mode);
    }

    protected T apply(T x) throws EvaluatingExceptions {
        return mode.abs(x);
    }
}
