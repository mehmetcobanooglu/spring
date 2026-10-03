package com.mehmet.oyunmagazasi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Oyun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private Double fiyat;
    private Integer stok;

    @ManyToMany(mappedBy = "oyunlar")
    @JsonIgnore
    private List<Kullanici> kullanicilar;

    @ManyToOne
    @JoinColumn(name = "yapimci_id")
    private Yapimci yapimci;

    @ManyToMany
    @JoinTable(name = "oyun_kategori", joinColumns = @JoinColumn(name = "oyun_id"), inverseJoinColumns = @JoinColumn(name = "kategori_id"))
    private List<Kategori> kategoriler;

}
