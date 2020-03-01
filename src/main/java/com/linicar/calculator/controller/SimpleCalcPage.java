package com.linicar.calculator.controller;


import com.linicar.calculator.service.ParserService;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//получает строку-кидает её в парсер
//получает сроку от парсера-кидает её в ответ
public class SimpleCalcPage extends Page {
    private static String mode = "i";
    private static ParserService parserService;

    public SimpleCalcPage() throws UnsupportedModeException {//этого здесь быть не должно
        parserService = new ParserService(mode);
    }

    @RequestMapping(value = "/commons", method = RequestMethod.GET)
    public String greetingForm(String expression) throws EvaluatingExceptions, ParserException {
        return "commons";
    }

}
