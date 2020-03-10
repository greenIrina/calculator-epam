package com.linicar.calculator.controller;

import com.linicar.calculator.repository.ParserRepository;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.EvaluatingExceptions;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.ParserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class Page {
    @ModelAttribute("message")
    public String getMessage(HttpSession httpSession) {
        String message = (String) httpSession.getAttribute("message");
        httpSession.removeAttribute("message");
        return message;
    }

    public void putMessage(HttpSession httpSession, String message) {
        httpSession.setAttribute("message", message);
    }

    void calculation(String expr, HttpSession httpSession, ParserRepository parserRepository) {
        try {
            Double ans = parserRepository.evaluate(expr);
            if (ans - ans.intValue() == 0) {
                putMessage(httpSession,  expr + " = " + ans.intValue());
            } else {
                putMessage(httpSession,  expr + " = " + ans);
            }
        } catch (ParserException | EvaluatingExceptions e) {
            putMessage(httpSession, "Error: " + e.getMessage());
        }
    }
}
