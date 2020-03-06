package com.linicar.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpPage extends Page {
    @GetMapping("help")
    public String help() {
        return "helpPage";
    }
}
