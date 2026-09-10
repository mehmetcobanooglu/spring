package com.mehmet.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.relationship.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
