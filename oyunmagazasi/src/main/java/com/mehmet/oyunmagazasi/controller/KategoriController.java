package com.mehmet.oyunmagazasi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.oyunmagazasi.entity.Kategori;
import com.mehmet.oyunmagazasi.service.KategoriService;

@RequestMapping("/kategori")
@RestController
public class KategoriController {

    private final KategoriService kategoriService;

    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @GetMapping
    public List<Kategori> getir() {
        return kategoriService.tümünüGetir();
    }

    @PostMapping
    public Kategori ekle(@RequestBody Kategori kategori) {
        return kategoriService.kaydet(kategori);
    }
}
