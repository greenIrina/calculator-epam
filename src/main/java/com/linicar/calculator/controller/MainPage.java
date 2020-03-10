package com.linicar.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage extends Page {

    @GetMapping({"", "/"})
    public String mainPage() {
        return "MainPage";
    }
}
