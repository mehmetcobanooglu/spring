package com.mehmet.maas_sistem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.maas_sistem.entity.Avans;
import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.repository.AvansRepository;
import com.mehmet.maas_sistem.repository.EmployeeRepository;

@Service
public class AvansService {

    private final AvansRepository avansRepository;
    private final EmployeeRepository employeeRepository;

    public AvansService(AvansRepository avansRepository, EmployeeRepository employeeRepository) {
        this.avansRepository = avansRepository;
        this.employeeRepository = employeeRepository;
    }

    public Avans avansVer(Long employeeId, double tutar) {
        Employee emp = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Personel bulunamadı"));

        Avans avans = new Avans();
        avans.setEmployee(emp);
        avans.setTutar(tutar);
        avans.setTarih(LocalDate.now());

        return avansRepository.save(avans);
    }

    public List<Avans> listele(Employee employee) {
        return avansRepository.findByEmployee(employee);
    }

    public void sil(Employee employee) {
        avansRepository.deleteAll(avansRepository.findByEmployee(employee));
    }

    // Tüm avansları sil
    public void silTumunu() {
        avansRepository.deleteAll();
    }
}
