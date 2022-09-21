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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = {"empleado"})
@Controller
public class MainController {


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





    @GetMapping(value={"/nuevo"})
    public String nuevoEmployee(Model model){
        model.addAttribute("listaJefes",employeesRepository.buscaJefes());
        model.addAttribute("listaJobs",jobsRepository.findAll());
        model.addAttribute("listaDepartment",departmentsRepository.findAll());

        return "employee/newuser";
    }

    @PostMapping(value = {"/savenew"})
    public String guardarEmployee(Employee employee, RedirectAttributes attr){


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("*/*/**//**/*/*/**/*/*/**/*/*/**/*/**/*");
        System.out.println(employee.getJob());
        employee.setHireDate(Instant.now());
        System.out.println(Instant.now());
        System.out.println("*/*/**//**/*/*/**/*/*/**/*/*/**/*/**/*");

        employeesRepository.save(employee);
        employeesRepository.GuardarContrasena(employee.getPassword(),employee.getId());
        if(employee.getId()!=0){
            attr.addFlashAttribute("guardado","El empleado se ha editado exitosamente");
        }else{
            attr.addFlashAttribute("guardado","El empleado se ha creado exitosamente");
        }
        return "redirect:/empleado";
    }



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



    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employee> optProduct = employeesRepository.findById(id);

        if (optProduct.isPresent()) {
            employeesRepository.deleteById(id);
        }
        return "redirect:/empleado";

    }






}
