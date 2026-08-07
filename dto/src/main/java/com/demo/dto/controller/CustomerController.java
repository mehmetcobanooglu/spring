package com.demo.dto.controller;

import com.demo.dto.dto.CustomerRequestDto;
import com.demo.dto.dto.CustomerResponseDto;
import com.demo.dto.entity.Customer;
import com.demo.dto.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.tümünügetir();
    }

    @PostMapping("/customers")
    public String ekle(
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        customerService.saveCustomer(customerRequestDto);

        return "Customer Oluşturuldu";
    }
}