package com.mehmet.maas_sistem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "avans")
public class Avans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double tutar;

    private LocalDate tarih;

    @ManyToOne
    @JoinColumn(name = "employee_id")

    private Employee employee;

    public Avans() {

    }

    public Avans(double tutar, LocalDate tarih, Employee employee) {
        this.tutar = tutar;
        this.tarih = tarih;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
