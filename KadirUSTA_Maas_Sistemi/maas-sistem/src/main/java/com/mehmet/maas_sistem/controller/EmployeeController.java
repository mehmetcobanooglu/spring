package com.mehmet.maas_sistem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.kaydet(employee);
    }

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.listele();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/update-gelmedigi-gun/{id}")
    public String updateGelmedigiGun(@PathVariable Long id, @RequestParam int gun) {
        Employee emp = employeeService.getById(id);
        emp.setGelmedigiGun(gun);
        employeeService.save(emp);
        return "Gelmediği gün sayısı güncellendi!";
    }
}
