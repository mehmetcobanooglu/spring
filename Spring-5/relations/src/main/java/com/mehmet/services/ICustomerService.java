package com.mehmet.services;

import com.mehmet.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);

}
