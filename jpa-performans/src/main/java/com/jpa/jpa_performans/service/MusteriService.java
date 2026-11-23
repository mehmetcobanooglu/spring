package com.jpa.jpa_performans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.jpa_performans.entity.Musteri;
import com.jpa.jpa_performans.repository.MusteriRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusteriService {

    private final MusteriRepository musteriRepository;

    public List<Musteri> tumMusterileriGetir() {
        return musteriRepository.findAll();
    }

    public Musteri musteriEkle(Musteri musteri) {
        return musteriRepository.save(musteri);
    }

    // public List<Musteri> tumMusterileriSiparisleriyleGetir() {

    // List<Musteri> musteriler = musteriRepository.findAll();

    // for (Musteri musteri : musteriler) {
    // System.out.println(
    // musteri.getName() + " - Sipariş Sayısı: " + musteri.getSiparisler().size());
    // }
    // return musteriler;
    // }

    public List<Musteri> tumMusterileriSiparisleriyleGetir() {
        return musteriRepository.musterileriSiparislerleGetir();
    }

    public List<Musteri> entityGraphIleGetir() {
        return musteriRepository.entityGraphIleGetir();
    }
}
