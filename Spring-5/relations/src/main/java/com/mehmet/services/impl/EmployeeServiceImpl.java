package com.mehmet.services.impl;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmet.dto.DtoDepartment;
import com.mehmet.dto.DtoEmployee;
import com.mehmet.entities.Employee;
import com.mehmet.repository.EmployeeRepository;
import com.mehmet.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository a;

    @Override
    public List<DtoEmployee> findAllEmployees() {
        List<DtoEmployee> d = new ArrayList<>();
        List<Employee> b = a.findAll();

        if (b != null && !b.isEmpty()) {

            for (Employee c : b) {
                DtoEmployee z = new DtoEmployee();
                BeanUtils.copyProperties(c, z);
                z.setDepartment(new DtoDepartment(c.getDepartment().getId(), c.getDepartment().getDepartmentName()));
                d.add(z);
            }
        }
        return d;
    }

}
