package com.mehmetcobanoglu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetcobanoglu.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
