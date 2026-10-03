package com.mehmet.maas_sistem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maas_hesap")
public class MaasHesap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double aylikMaas;

    private double toplamAvans;

    private double kesinti;

    private double netMaas;

    private int ay;
    private int yil;

    private LocalDate hesapTarihi;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public MaasHesap() {

    }

    public MaasHesap(double aylikMaas, double toplamAvans, double kesinti, double netMaas,
            int ay, int yil, LocalDate hesapTarihi, Employee employee) {
        this.aylikMaas = aylikMaas;
        this.toplamAvans = toplamAvans;
        this.kesinti = kesinti;
        this.netMaas = netMaas;
        this.ay = ay;
        this.yil = yil;
        this.hesapTarihi = hesapTarihi;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public double getAylikMaas() {
        return aylikMaas;
    }

    public void setAylikMaas(double aylikMaas) {
        this.aylikMaas = aylikMaas;
    }

    public double getToplamAvans() {
        return toplamAvans;
    }

    public void setToplamAvans(double toplamAvans) {
        this.toplamAvans = toplamAvans;
    }

    public double getKesinti() {
        return kesinti;
    }

    public void setKesinti(double kesinti) {
        this.kesinti = kesinti;
    }

    public double getNetMaas() {
        return netMaas;
    }

    public void setNetMaas(double netMaas) {
        this.netMaas = netMaas;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public LocalDate getHesapTarihi() {
        return hesapTarihi;
    }

    public void setHesapTarihi(LocalDate hesapTarihi) {
        this.hesapTarihi = hesapTarihi;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
