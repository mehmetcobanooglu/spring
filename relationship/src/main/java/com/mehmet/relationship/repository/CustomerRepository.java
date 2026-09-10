package com.mehmet.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.relationship.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
