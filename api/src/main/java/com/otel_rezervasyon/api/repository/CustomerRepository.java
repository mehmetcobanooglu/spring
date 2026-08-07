package com.otel_rezervasyon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otel_rezervasyon.api.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}