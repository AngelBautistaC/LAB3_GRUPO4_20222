package com.example.lab3_grupo4.Controller;

import com.example.lab3_grupo4.Entity.Employee;
import com.example.lab3_grupo4.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


    @Autowired
    CountryRepository countryRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    Job_historyRepository job_historyRepository;
    @Autowired
    LocationsRepository locationsRepository;
    @Autowired
    RegionsRepository regionsRepository;


    @GetMapping(value = {"/listaEmpleado",""})
    public String listaEmpleado(Model model){

        model.addAttribute("listaEmpleados",employeesRepository.findAll());

        return "employee/lista";

    }

    @PostMapping(value={"/search"})
    public String buscarEmployee(@RequestParam("searchField") String searchField, Model model){
        List<Employee> listaEmployees=employeesRepository.buscarEmployee(searchField);
        model.addAttribute("listaEmpleados",listaEmployees);

        return "employee/lista";
    }







}
