package com.mehmet.relationship.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.relationship.entity.Customer;
import com.mehmet.relationship.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
