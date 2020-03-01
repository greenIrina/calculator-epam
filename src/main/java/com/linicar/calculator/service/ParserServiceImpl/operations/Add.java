package com.linicar.calculator.service.ParserServiceImpl.operations;

import com.linicar.calculator.repository.ParserRepository.TripleExpression;
import com.linicar.calculator.repository.ParserRepository.ModeOperations;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public class Add<T> extends AbstractBinaryOperator<T> {

    public Add(TripleExpression<T> x, TripleExpression<T> y, ModeOperations<T> mode) {
        super(x, y, mode);
    }

    protected T apply(T x, T y) throws EvaluatingExceptions {
        return mode.add(x, y);
    }
}
