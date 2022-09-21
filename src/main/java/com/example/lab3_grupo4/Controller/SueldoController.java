package com.example.lab3_grupo4.Controller;

import com.example.lab3_grupo4.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SueldoController {
    @Autowired
    JobsRepository jobsRepository;


    @GetMapping(value="/lista_sueldo")
    public String listaSueldos(Model model){
        model.addAttribute("listaSueldos", jobsRepository.sueldos());
        return "";
    }

}
