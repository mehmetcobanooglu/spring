package com.mehmet.maas_sistem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.maas_sistem.entity.Avans;
import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.service.AvansService;
import com.mehmet.maas_sistem.service.EmployeeService;

@RestController
@RequestMapping("/api/avans")
public class AvansController {

    private final AvansService avansService;
    private final EmployeeService employeeService;

    public AvansController(AvansService avansService, EmployeeService employeeService) {
        this.avansService = avansService;
        this.employeeService = employeeService;
    }

    @PostMapping("/give/{employeeId}")
    public Avans giveAvans(@PathVariable Long employeeId, @RequestParam double tutar) {
        return avansService.avansVer(employeeId, tutar);
    }

    @GetMapping("/list/{employeeId}")
    public List<Avans> listEmployeeAvans(@PathVariable Long employeeId) {
        Employee emp = employeeService.getById(employeeId);
        return avansService.listele(emp);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployeeAvans(@PathVariable Long employeeId) {
        Employee emp = employeeService.getById(employeeId);
        avansService.sil(emp);
        return "Avanslar silindi: " + emp.getAd() + " " + emp.getSoyad();
    }

    // Tüm avansları sil
    @DeleteMapping("/delete-all")
    public String deleteAllAvans() {
        avansService.silTumunu();
        return "Tüm avanslar silindi!";
    }
}
