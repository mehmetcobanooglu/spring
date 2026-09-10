package com.mehmet.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.relationship.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
