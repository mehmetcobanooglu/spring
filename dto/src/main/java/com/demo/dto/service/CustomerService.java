package com.demo.dto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.dto.CustomerRequestDto;
import com.demo.dto.dto.CustomerResponseDto;
import com.demo.dto.entity.Customer;
import com.demo.dto.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDto> tümünügetir() {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponseDto> dtoCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerResponseDto dto = new CustomerResponseDto(customer.getId(), customer.getName(),
                    customer.getEmail());
            dtoCustomers.add(dto);
        }
        return dtoCustomers;
    }

    public void saveCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();

        customer.setName(customerRequestDto.getName());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setPassword(customerRequestDto.getPassword());
        customerRepository.save(customer);
    }
}
