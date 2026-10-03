package com.mehmet.oyunmagazasi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String ad;
    private String soyad;
    private String telefonNumarasi;
    private String email;
    private Integer yas;

    @OneToOne
    @JoinColumn(name = "adres_id")
    private Adres adres;

    @OneToMany(mappedBy = "kullanici")
    @JsonBackReference
    private List<Siparis> siparisler;

    @ManyToMany

    @JoinTable(name = "kullanici_oyun", joinColumns = @JoinColumn(name = "kullanici_id"), inverseJoinColumns = @JoinColumn(name = "oyun_id")

    )

    private List<Oyun> oyunlar;
}
