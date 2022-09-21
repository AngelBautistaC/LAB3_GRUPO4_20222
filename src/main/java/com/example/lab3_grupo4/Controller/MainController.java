package com.example.lab3_grupo4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("")
    public String newUser(){

        return "newuser";
    }
}
