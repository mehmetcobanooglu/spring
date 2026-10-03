package com.mehmet.oyunmagazasi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.oyunmagazasi.repository.KategoriRepository;
import com.mehmet.oyunmagazasi.repository.OyunRepository;
import com.mehmet.oyunmagazasi.repository.YapimciRepository;
import com.mehmet.oyunmagazasi.entity.Kategori;
import com.mehmet.oyunmagazasi.entity.Oyun;
import com.mehmet.oyunmagazasi.entity.Yapimci;

@Service
public class OyunService {

    private final OyunRepository oyunRepository;
    private final YapimciRepository yapimciRepository;

    private final KategoriRepository kategoriRepository;

    public OyunService(OyunRepository oyunRepository, YapimciRepository yapimciRepository,
            KategoriRepository kategoriRepository) {
        this.oyunRepository = oyunRepository;
        this.yapimciRepository = yapimciRepository;
        this.kategoriRepository = kategoriRepository;
    }

    public Oyun kategoriAta(Long oyun_ID, Long kategori_ID) {
        Oyun oyun = oyunRepository.findById(oyun_ID).orElse(null);
        Kategori kategori = kategoriRepository.findById(kategori_ID).orElse(null);

        oyun.getKategoriler().add(kategori);
        return oyunRepository.save(oyun);
    }

    public Oyun yapimciAta(Long oyun_ID, Long yapimci_ID) {
        Oyun oyun = oyunRepository.findById(oyun_ID).orElse(null);
        Yapimci yapimci = yapimciRepository.findById(yapimci_ID).orElse(null);

        oyun.setYapimci(yapimci);
        return oyunRepository.save(oyun);
    }

    public List<Oyun> tümünüGetir() {
        return oyunRepository.findAll();
    }

    public Oyun kaydet(Oyun oyun) {
        return oyunRepository.save(oyun);
    }

}
