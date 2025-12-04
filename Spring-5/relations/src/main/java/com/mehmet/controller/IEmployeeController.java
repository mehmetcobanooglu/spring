package com.mehmet.controller;

import java.util.List;

import com.mehmet.dto.DtoEmployee;

public interface IEmployeeController {

    public List<DtoEmployee> findAllEmployees();
}
