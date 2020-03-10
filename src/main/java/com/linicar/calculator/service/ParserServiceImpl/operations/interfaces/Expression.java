package com.linicar.calculator.service.ParserServiceImpl.operations.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.NotIntegerFactorialException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;

public interface Expression {
    Double evaluate() throws EvaluatingExceptions, UnsupportedModeException;
}
