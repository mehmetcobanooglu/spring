package com.egitim.bankatransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egitim.bankatransfer.entity.Hesap;

public interface HesapRepository extends JpaRepository<Hesap, Long> {

}