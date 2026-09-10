package com.mehmet.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.relationship.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
