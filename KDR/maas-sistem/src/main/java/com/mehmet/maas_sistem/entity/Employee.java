package com.mehmet.maas_sistem.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;
    private double maas;
    private LocalDate iseGirisTarihi;

    private int gelmedigiGun; // ← EKLENDİ

    public Employee() {

    }

    public Employee(String ad, String soyad, double maas, LocalDate iseGirisTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.maas = maas;
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public Long getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public LocalDate getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(LocalDate iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public int getGelmedigiGun() {
        return gelmedigiGun;
    }

    public void setGelmedigiGun(int gelmedigiGun) {
        this.gelmedigiGun = gelmedigiGun;
    }
}
