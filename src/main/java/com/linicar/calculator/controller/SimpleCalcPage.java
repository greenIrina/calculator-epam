package com.linicar.calculator.controller;

import com.linicar.calculator.service.SimpleCalcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class SimpleCalcPage extends Page {
    private static SimpleCalcService simpleCalcService;

    public SimpleCalcPage() {
        simpleCalcService = new SimpleCalcService();
    }

    @GetMapping("base")
    public String calc(String expression, Model model) {
        model.addAttribute("expression", expression);
        return "simpleCalc";
    }

    @PostMapping("base")
    public String calc(@Valid @ModelAttribute("expression") String expression, HttpSession httpSession) {
        calculation(expression, httpSession, simpleCalcService);
        return "simpleCalc";
    }
}
