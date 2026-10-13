package com.sporsalonu.yonetim.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Uyelik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long baslangicTarihi;

    private Long bitisTarihi;

    private Boolean aktif;

    @ManyToOne
    @JoinColumn(name = "uye_id")
    private Uye uye;

    @ManyToOne
    @JoinColumn(name = "paket_id")
    private Paket paket;

    @OneToMany(mappedBy = "uyelik")
    private List<Odeme> odemeler;
}
