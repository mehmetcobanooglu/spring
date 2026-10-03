package com.mehmet.maas_sistem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.maas_sistem.DTO.MaasDTO;
import com.mehmet.maas_sistem.entity.Avans;
import com.mehmet.maas_sistem.entity.Employee;
import com.mehmet.maas_sistem.entity.MaasHesap;
import com.mehmet.maas_sistem.repository.AvansRepository;
import com.mehmet.maas_sistem.repository.EmployeeRepository;
import com.mehmet.maas_sistem.repository.MaasHesapRepository;

@Service
public class MaasHesapService {

    private final MaasHesapRepository maasHesapRepository;
    private final AvansRepository avansRepository;
    private final EmployeeRepository employeeRepository;

    public MaasHesapService(MaasHesapRepository maasHesapRepository,
            AvansRepository avansRepository,
            EmployeeRepository employeeRepository) {
        this.maasHesapRepository = maasHesapRepository;
        this.avansRepository = avansRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<MaasHesap> listele(Employee employee) {
        return maasHesapRepository.findByEmployee(employee);
    }

    public List<MaasDTO> hesaplaAylikMaaslar() {

        LocalDate bugun = LocalDate.now();
        LocalDate baslangic = bugun.minusMonths(1).withDayOfMonth(15);
        LocalDate bitis = bugun.withDayOfMonth(14);

        List<Employee> personeller = employeeRepository.findAll();
        List<MaasDTO> sonuc = new ArrayList<>();

        for (Employee emp : personeller) {

            // Avans toplamı
            List<Avans> avanslar = avansRepository.findByEmployeeAndTarihBetween(emp, baslangic, bitis);
            double toplamAvans = avanslar.stream().mapToDouble(Avans::getTutar).sum();

            // Gelmediği gün kesintisi
            int gelmedigiGun = emp.getGelmedigiGun();
            double gunlukMaas = emp.getMaas() / 30;
            double gelmediKesinti = gunlukMaas * gelmedigiGun;

            // Net maaş
            double netMaas = emp.getMaas() - toplamAvans - gelmediKesinti;

            // DTO oluştur
            sonuc.add(new MaasDTO(
                    emp.getId(),
                    emp.getAd() + " " + emp.getSoyad(),
                    emp.getMaas(),
                    toplamAvans,
                    gelmedigiGun,
                    netMaas));
        }

        return sonuc;
    }
}
