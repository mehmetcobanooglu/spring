package com.mehmet.services;

import java.util.List;

import com.mehmet.dto.DtoEmployee;

public interface IEmployeeService {

    public List<DtoEmployee> findAllEmployees();
}
