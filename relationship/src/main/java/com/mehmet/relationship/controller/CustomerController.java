package com.mehmet.relationship.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.relationship.entity.Customer;
import com.mehmet.relationship.entity.Product;
import com.mehmet.relationship.repository.CustomerRepository;
import com.mehmet.relationship.repository.ProductRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CustomerController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    // Tüm Müşterileri Getir
    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer mevcutCustomer = customerRepository.findById(id).orElse(null);

        if (mevcutCustomer == null) {
            return null;
        }

        mevcutCustomer.setName(customer.getName());
        return customerRepository.save(mevcutCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @PostMapping("/{customerId}/products/{productId}")
    public Customer addProductToCustomer(
            @PathVariable Long customerId,
            @PathVariable Long productId) {

        Customer customer = customerRepository
                .findById(customerId)
                .orElse(null);

        Product product = productRepository
                .findById(productId)
                .orElse(null);

        if (customer == null || product == null) {
            return null;
        }

        customer.getProducts().add(product);

        return customerRepository.save(customer);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    public Customer removeProductFromCustomer(
            @PathVariable Long customerId, @PathVariable Long productId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (customer == null || product == null) {
            return null;
        }

        customer.getProducts().remove(product);
        return customerRepository.save(customer);
    }
}
