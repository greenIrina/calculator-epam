package com.linicar.calculator.service.ParserServiceImpl.operations.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;

public interface Operations {

    Double parseConst(String expression) throws ParserException;

    Double add(Double left, Double right);

    Double sub(Double left, Double right);

    Double divide(Double left, Double right);

    Double mult(Double left, Double right);

    Double negative(Double x);

    Double abs(Double x);

    Double mod(Double left, Double right);

    Double sqrt(Double x) throws EvaluatingExceptions;

    Double factorial(Double x) throws EvaluatingExceptions;

    Double sin(Double x);

    Double cos(Double x);

    Double tan(Double x);

    Double atan(Double x);

    Double pow(Double x, Double y);

    Double log(Double x, Double y) throws EvaluatingExceptions;
}
