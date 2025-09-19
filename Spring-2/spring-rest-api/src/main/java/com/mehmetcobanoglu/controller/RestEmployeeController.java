package com.mehmetcobanoglu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetcobanoglu.model.Employee;
import com.mehmetcobanoglu.services.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

    public List<Employee> getAllEmployees
}
