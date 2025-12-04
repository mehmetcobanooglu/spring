package com.mehmet.maas_sistem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmet.maas_sistem.entity.Avans;
import com.mehmet.maas_sistem.entity.Employee;

@Repository
public interface AvansRepository extends JpaRepository<Avans, Long> {

    // Belirli tarihler arasında avansları getir
    List<Avans> findByEmployeeAndTarihBetween(Employee employee, LocalDate start, LocalDate end);

    // Tüm avansları getir
    List<Avans> findByEmployee(Employee employee);
}
