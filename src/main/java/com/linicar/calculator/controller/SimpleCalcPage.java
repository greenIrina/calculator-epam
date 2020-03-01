package com.linicar.calculator.controller;


import com.linicar.calculator.service.ExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleCalcPage extends Page {
    private final ExpressionParser parser;
    public SimpleCalcPage(ExpressionParser parser){
        this.parser = parser;
    }



    //получает строку-кидает её в парсер
    //получает сроку от парсера-кидает её в ответ

}
