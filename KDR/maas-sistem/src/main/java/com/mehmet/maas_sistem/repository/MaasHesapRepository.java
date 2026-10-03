package com.mehmet.maas_sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.entity.MaasHesap;

@Repository
public interface MaasHesapRepository extends JpaRepository<MaasHesap, Long> {

    List<MaasHesap> findByEmployee(Employee employee);
}
