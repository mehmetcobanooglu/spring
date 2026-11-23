package com.jpa.jpa_performans.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpa_performans.entity.Musteri;
import com.jpa.jpa_performans.service.MusteriService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/musteriler")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;

    @GetMapping
    public List<Musteri> tumMusterileriGetir() {
        return musteriService.tumMusterileriGetir();
    }

    @PostMapping
    public Musteri musteriEkle(@RequestBody Musteri musteri) {
        return musteriService.musteriEkle(musteri);
    }

    @GetMapping("/siparislerle")
    public List<Musteri> siparislerleGetir() {
        return musteriService.tumMusterileriSiparisleriyleGetir();
    }

    @GetMapping("/entity-graph")
    public List<Musteri> entityGraphIleGetir() {
        return musteriService.entityGraphIleGetir();
    }
}
