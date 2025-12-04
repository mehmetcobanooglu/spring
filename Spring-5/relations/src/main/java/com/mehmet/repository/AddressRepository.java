package com.mehmet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmet.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
