package com.linicar.calculator.repository;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import org.springframework.stereotype.Repository;

@Repository
public interface ParserRepository {
    Double evaluate(String expression) throws ParserException, EvaluatingExceptions;
}
