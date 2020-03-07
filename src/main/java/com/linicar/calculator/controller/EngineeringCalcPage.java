package com.linicar.calculator.controller;

import com.linicar.calculator.service.EngineeringCalcService;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EngineeringCalcPage extends Page {
    private EngineeringCalcService engineeringCalcService;

    public EngineeringCalcPage(EngineeringCalcService engineeringCalcService) {
        this.engineeringCalcService = engineeringCalcService;
    }

    @GetMapping("engineer")
    public String calcEng(String expressionEng, Model model) {
        model.addAttribute("expressionEng", expressionEng);
        return "engineerCalc";
    }

    @PostMapping("engineer")
    public String calcEng(@Valid @ModelAttribute("expressionEng") String expressionEng, HttpSession httpSession)
            throws EvaluatingExceptions {
        calculation(expressionEng, httpSession, engineeringCalcService);
        return "engineerCalc";
    }
}
