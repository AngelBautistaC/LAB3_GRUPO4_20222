package com.example.lab3_grupo4.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {""})
public class Index {


    @GetMapping(value = {""})
    public String paginaInicio(){
        return "index";
    }

}
