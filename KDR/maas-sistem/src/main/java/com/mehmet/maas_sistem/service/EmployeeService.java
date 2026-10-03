package com.mehmet.maas_sistem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee kaydet(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> listele() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personel bulunamadı"));
    }
}
