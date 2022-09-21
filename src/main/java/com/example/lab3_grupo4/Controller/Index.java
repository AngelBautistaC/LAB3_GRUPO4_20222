package com.example.lab3_grupo4.Controller;


import com.example.lab3_grupo4.Entity.Job;
import com.example.lab3_grupo4.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {""})
public class Index {

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


    @GetMapping(value = {""})
    public String paginaInicio(){
        return "index";
    }

}
