package com.example.lab3_grupo4.Controller;

import com.example.lab3_grupo4.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    Job_historyRepository job_historyRepository;

    @Autowired
    LocationsRepository locationsRepository;

    @Autowired
    RegionsRepository regionsRepository;



}
