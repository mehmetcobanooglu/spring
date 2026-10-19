
package com.sporsalonu.yonetim.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Uyelik {

    public Uyelik() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long baslangicTarihi;
    private Long bitisTarihi;
    private Boolean aktif;

    @ManyToOne
    @JoinColumn(name = "uye_id")
    @JsonBackReference("uye-uyelikler")
    private Uye uye;

    @ManyToOne
    @JoinColumn(name = "paket_id")
    @JsonBackReference("paket-uyelikler")
    private Paket paket;

    @OneToMany(mappedBy = "uyelik")
    @JsonManagedReference("uyelik-odemeler")
    private List<Odeme> odemeler;
}
