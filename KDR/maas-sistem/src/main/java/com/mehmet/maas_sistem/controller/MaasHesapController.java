package com.mehmet.maas_sistem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.maas_sistem.DTO.MaasDTO;
import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.entity.MaasHesap;
import com.mehmet.maas_sistem.service.EmployeeService;
import com.mehmet.maas_sistem.service.MaasHesapService;

@RestController
@RequestMapping("/api/maas")
public class MaasHesapController {

    private final MaasHesapService maasHesapService;
    private final EmployeeService employeeService;

    public MaasHesapController(MaasHesapService maasHesapService, EmployeeService employeeService) {
        this.maasHesapService = maasHesapService;
        this.employeeService = employeeService;
    }

    // @PostMapping("/hesapla/{employeeId}")
    // public MaasHesap hesapla(
    // @PathVariable Long employeeId,
    // @RequestParam double kesinti,
    // @RequestParam int gelmedigiGun,
    // @RequestParam int ay,
    // @RequestParam int yil) {
    // return maasHesapService.maasHesapla(employeeId, kesinti, ay, yil,
    // gelmedigiGun);
    // }

    @GetMapping("/list/{employeeId}")
    public List<MaasHesap> listEmployeeMaas(@PathVariable Long employeeId) {
        Employee emp = employeeService.getById(employeeId);
        return maasHesapService.listele(emp);
    }

    @GetMapping("/hesapla-aylik")
    public List<MaasDTO> hesaplaAylik() {
        return maasHesapService.hesaplaAylikMaaslar();
    }
}
