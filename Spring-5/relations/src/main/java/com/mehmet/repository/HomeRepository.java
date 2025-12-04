package com.mehmet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.entities.Home;

public interface HomeRepository extends JpaRepository<Home, Long> {

}
