package com.mehmet.oyunmagazasi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.oyunmagazasi.entity.Kullanici;
import com.mehmet.oyunmagazasi.service.KullaniciService;

import jakarta.validation.Valid;

import com.mehmet.oyunmagazasi.dto.KullaniciRequestDto;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @GetMapping
    public List<Kullanici> getir() {
        return kullaniciService.tumKullanicilariGetir();
    }

    @PostMapping
    public Kullanici ekle(@Valid @RequestBody KullaniciRequestDto dto) {
        return kullaniciService.kullaniciEkle(dto);
    }

    @GetMapping("/{id}")
    public Kullanici kullaniciGetir(@PathVariable Long id) {

        return kullaniciService.kullaniciGetir(id);

    }

    @PostMapping("/{kullanici_ID}/oyunlar/{oyun_ID}")
    public Kullanici oyunEkle(@PathVariable Long kullanici_ID, @PathVariable Long oyun_ID) {

        return kullaniciService.oyunEkle(kullanici_ID, oyun_ID);
    }

}
