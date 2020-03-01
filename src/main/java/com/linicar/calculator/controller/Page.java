package com.linicar.calculator.controller;

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

}
