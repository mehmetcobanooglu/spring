package com.otel_rezervasyon.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.otel_rezervasyon.api.entity.Customer;
import com.otel_rezervasyon.api.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Customer> tümünüListele() {
        return repository.findAll();
    }

    public void musterisil(Long id) {
        repository.deleteById(id);
    }
}
