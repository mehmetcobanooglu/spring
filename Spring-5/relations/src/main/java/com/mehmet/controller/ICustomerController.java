package com.mehmet.controller;

import com.mehmet.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);
}
