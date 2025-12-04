package com.mehmetcobanoglu.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetcobanoglu.dto.DtoDepartment;
import com.mehmetcobanoglu.dto.DtoEmployee;
import com.mehmetcobanoglu.exception.BaseException;
import com.mehmetcobanoglu.model.Department;
import com.mehmetcobanoglu.model.Employee;
import com.mehmetcobanoglu.repository.EmployeeRepository;
import com.mehmetcobanoglu.response.ErrorMessage;
import com.mehmetcobanoglu.service.IEmployeeService;

@Service

public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {

        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST));
        }

        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
