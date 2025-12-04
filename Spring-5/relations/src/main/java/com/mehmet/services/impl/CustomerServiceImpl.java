package com.mehmet.services.impl;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.mehmet.entities.Address;

import com.mehmet.dto.DtoAddress;
import com.mehmet.dto.DtoCustomer;
import com.mehmet.entities.Customer;

import com.mehmet.repository.CustomerRepository;
import com.mehmet.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {

        DtoCustomer dtoCustomer = new DtoCustomer();

        DtoAddress dtoAddress = new DtoAddress();
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;
    }

}
