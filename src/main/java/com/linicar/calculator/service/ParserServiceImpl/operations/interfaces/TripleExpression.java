package com.linicar.calculator.service.ParserServiceImpl.operations.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;

public interface TripleExpression {
    Double evaluate(Double x, Double y, Double z) throws EvaluatingExceptions, UnsupportedModeException, NotIntegerFactorialException;
}