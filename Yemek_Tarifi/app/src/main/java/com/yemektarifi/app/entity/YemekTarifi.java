package com.yemektarifi.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class YemekTarifi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String yemekAdi;

    private String kategori;

    private String malzemeler;

    private String yapilis;

    private int hazirlanmaSuresi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getYapilis() {
        return yapilis;
    }

    public void setYapilis(String yapilis) {
        this.yapilis = yapilis;
    }

    public int getHazirlanmaSuresi() {
        return hazirlanmaSuresi;
    }

    public void setHazirlanmaSuresi(int hazirlanmaSuresi) {
        this.hazirlanmaSuresi = hazirlanmaSuresi;
    }

}
