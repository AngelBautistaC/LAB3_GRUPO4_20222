package com.example.lab3_grupo4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = {"empleado"})
@Controller
public class MainController {


    @GetMapping("")
    public String newUser(){

        return "newuser";
    }





}
