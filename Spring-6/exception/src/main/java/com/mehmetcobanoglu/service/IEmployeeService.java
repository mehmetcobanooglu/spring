package com.mehmetcobanoglu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetcobanoglu.dto.DtoEmployee;
import com.mehmetcobanoglu.model.Employee;
import com.mehmetcobanoglu.repository.EmployeeRepository;

public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);
}
