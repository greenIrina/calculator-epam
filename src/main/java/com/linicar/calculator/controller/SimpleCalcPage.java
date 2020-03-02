package com.linicar.calculator.controller;


import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.UnsupportedModeException;
import com.linicar.calculator.service.SimpleCalcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//получает строку-кидает её в парсер
//получает сроку от парсера-кидает её в ответ
@Controller
public class SimpleCalcPage extends Page {
    private static SimpleCalcService simpleCalcService;

    public SimpleCalcPage() throws UnsupportedModeException {//этого здесь быть не должно(я про исключение)
//        String mode = "d";//считаем в даблах
        simpleCalcService = new SimpleCalcService();
    }

    //    @RequestMapping(value = "/commons", method = RequestMethod.GET)
    @GetMapping("calc")
    public String calc(String expression, Model model) throws EvaluatingExceptions, ParserException {
        model.addAttribute("expression", expression);
        return "simpleCalc";
    }

    @PostMapping("calc")
    public String calc(@Valid @ModelAttribute("expression") String expression, BindingResult bindingResult, HttpSession httpSession) throws EvaluatingExceptions, ParserException {
//        putMessage(httpSession, expression);
        try {
            String ans = simpleCalcService.evaluate(expression).toString();
            if (ans.substring(ans.length() - 2, ans.length()).equals(".0")) {
                putMessage(httpSession, "Result: " + ans.substring(0, ans.length() - 2));
            } else {
                putMessage(httpSession, "Result: " + ans);
            }
        } catch (ParserException e) {
            putMessage(httpSession, "Error: " + e.getMessage());
        }
        return "simpleCalc";

    }
}
