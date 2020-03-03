package com.linicar.calculator.service.ParserServiceImpl.ParsrInterfaces;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;

import java.math.BigDecimal;

public interface EngineeringOperations<T> extends SimpleOperations<T> {

    BigDecimal sin(BigDecimal x) throws EvaluatingExceptions;

    BigDecimal cos(BigDecimal x) throws EvaluatingExceptions;

    BigDecimal tan(BigDecimal x) throws EvaluatingExceptions;

    BigDecimal atan(BigDecimal x) throws EvaluatingExceptions;

    BigDecimal pow(BigDecimal x, BigDecimal y) throws EvaluatingExceptions;
}
