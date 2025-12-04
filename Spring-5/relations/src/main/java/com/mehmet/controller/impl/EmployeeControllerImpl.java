package com.mehmet.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.mehmet.controller.IEmployeeController;
import com.mehmet.dto.DtoEmployee;
import com.mehmet.services.IEmployeeService;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    private IEmployeeService a;

    @GetMapping(path = ("/list"))
    @Override
    public List<DtoEmployee> findAllEmployees() {
        return a.findAllEmployees();
    }

}
