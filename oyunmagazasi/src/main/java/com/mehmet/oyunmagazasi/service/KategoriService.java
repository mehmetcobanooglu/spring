package com.mehmet.oyunmagazasi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.oyunmagazasi.entity.Kategori;
import com.mehmet.oyunmagazasi.repository.KategoriRepository;

@Service
public class KategoriService {

    private final KategoriRepository kategoriRepository;

    public KategoriService(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    public List<Kategori> tümünüGetir() {
        return kategoriRepository.findAll();
    }

    public Kategori kaydet(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }
}
