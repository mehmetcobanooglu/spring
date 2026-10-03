package com.mehmet.oyunmagazasi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.oyunmagazasi.dto.KullaniciRequestDto;
import com.mehmet.oyunmagazasi.entity.Kullanici;
import com.mehmet.oyunmagazasi.entity.Oyun;
import com.mehmet.oyunmagazasi.exception.KullaniciBulunamadiException;
import com.mehmet.oyunmagazasi.mapper.KullaniciMapper;
import com.mehmet.oyunmagazasi.repository.KullaniciRepository;
import com.mehmet.oyunmagazasi.repository.OyunRepository;

@Service
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;
    private final KullaniciMapper kullaniciMapper;
    private final OyunRepository oyunRepository;

    public KullaniciService(
            KullaniciRepository kullaniciRepository,
            KullaniciMapper kullaniciMapper,
            OyunRepository oyunRepository) {

        this.kullaniciRepository = kullaniciRepository;
        this.kullaniciMapper = kullaniciMapper;
        this.oyunRepository = oyunRepository;
    }

    public List<Kullanici> tumKullanicilariGetir() {
        return kullaniciRepository.findAll();
    }

    public Kullanici kullaniciEkle(KullaniciRequestDto dto) {
        Kullanici kullanici = kullaniciMapper.toEntity(dto);
        return kullaniciRepository.save(kullanici);
    }

    public Kullanici kullaniciGetir(Long id) {

        return kullaniciRepository.findById(id)
                .orElseThrow(() -> new KullaniciBulunamadiException(
                        "ID'si : " + id + " olan kullanici bulunamadi"));
    }

    public Kullanici oyunEkle(Long kullanici_ID, Long oyun_ID) {

        Kullanici kullanici = kullaniciRepository.findById(kullanici_ID)
                .orElseThrow(() -> new KullaniciBulunamadiException(
                        "ID'si : " + kullanici_ID + " olan kullanici bulunamadi"));

        Oyun oyun = oyunRepository.findById(oyun_ID)
                .orElseThrow();

        kullanici.getOyunlar().add(oyun);

        return kullaniciRepository.save(kullanici);
    }

}