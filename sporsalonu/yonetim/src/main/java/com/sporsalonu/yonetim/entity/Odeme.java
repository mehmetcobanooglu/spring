
package com.sporsalonu.yonetim.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Odeme {

    public Odeme() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal tutar;
    private LocalDate odemeTarihi;
    private String odemeYontemi;
    private String odemeDurumu;

    @ManyToOne
    @JoinColumn(name = "uye_id")
    @JsonBackReference("uye-odemeler")
    private Uye uye;

    @ManyToOne
    @JoinColumn(name = "uyelik_id")
    @JsonBackReference("uyelik-odemeler")
    private Uyelik uyelik;
}
