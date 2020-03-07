package com.linicar.calculator.service.ParserServiceImpl.generic.interfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;

public interface Operations {

    //Simple and Engineering operation
    Double parseConst(String expression) throws ParserException;

    Double add(Double left, Double right) throws EvaluatingExceptions;

    Double sub(Double left, Double right) throws EvaluatingExceptions;

    Double divide(Double left, Double right) throws EvaluatingExceptions;

    Double mult(Double left, Double right) throws EvaluatingExceptions;

    Double negative(Double x) throws EvaluatingExceptions;

    Double getNumber(Double x);

    Double abs(Double x) throws EvaluatingExceptions;

    Double square(Double x) throws EvaluatingExceptions;

    Double mod(Double left, Double right) throws EvaluatingExceptions;

    Double sqrt(Double x) throws EvaluatingExceptions;


    //Engineering operation

    Double factorial(Double x) throws EvaluatingExceptions;

    Double sin(Double x) throws EvaluatingExceptions;

    Double cos(Double x) throws EvaluatingExceptions;

    Double tan(Double x) throws EvaluatingExceptions;

    Double atan(Double x) throws EvaluatingExceptions;

    Double pow(Double x, Double y) throws EvaluatingExceptions;

    Double log(Double x, Double y) throws EvaluatingExceptions;
}
