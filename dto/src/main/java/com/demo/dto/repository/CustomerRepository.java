package com.demo.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dto.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
