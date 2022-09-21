package com.example.lab3_grupo4.Controller;

import com.example.lab3_grupo4.Entity.Employee;
import com.example.lab3_grupo4.Repository.DepartmentsRepository;
import com.example.lab3_grupo4.Repository.EmployeesRepository;
import com.example.lab3_grupo4.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = {"empleado"})
@Controller
public class MainController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @Autowired
    JobsRepository jobsRepository;

    @GetMapping("nuevo")
    public String newUser(Model model){
        model.addAttribute("listaJefes",employeesRepository.buscaJefes());
        model.addAttribute("listaDepart",departmentsRepository.findAll());
        model.addAttribute("listaJobs",jobsRepository.findAll());

        return "newuser";
    }

    @PostMapping("savenew")
    public String saveUser(Employee employee){
        employeesRepository.save(employee);
        return "redirect:/empleado";
    }





}
