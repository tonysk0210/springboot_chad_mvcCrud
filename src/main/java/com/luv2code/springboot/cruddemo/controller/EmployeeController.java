package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get employees from the service
        model.addAttribute("employees", employeeService.findAll());
        // add to the spring model
        return "list-employees"; // return the view name
    }
}
