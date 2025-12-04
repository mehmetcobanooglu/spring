package com.mehmetcobanoglu.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetcobanoglu.controller.RestEmployeeController;
import com.mehmetcobanoglu.dto.DtoEmployee;
import com.mehmetcobanoglu.model.Employee;
import com.mehmetcobanoglu.model.RootEntity;
import com.mehmetcobanoglu.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements RestEmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/list/{id}")
    @Override
    public RootEntity<DtoEmployee> findDtoEmployeeById(@PathVariable(value = "id") Long id) {
        return ok(employeeService.findEmployeeById(id));
    }

}
