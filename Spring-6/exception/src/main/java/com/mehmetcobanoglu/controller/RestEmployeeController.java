package com.mehmetcobanoglu.controller;

import com.mehmetcobanoglu.dto.DtoEmployee;
import com.mehmetcobanoglu.model.RootEntity;

public interface RestEmployeeController {

    public RootEntity<DtoEmployee> findDtoEmployeeById(Long id);
}
