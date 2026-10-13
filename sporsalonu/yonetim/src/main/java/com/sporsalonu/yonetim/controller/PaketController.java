package com.sporsalonu.yonetim.controller;

import com.sporsalonu.yonetim.entity.Paket;
import com.sporsalonu.yonetim.service.PaketService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paketler")
public class PaketController {

    private final PaketService paketService;

    public PaketController(PaketService paketService) {
        this.paketService = paketService;
    }

    @GetMapping
    public List<Paket> getir() {
        return paketService.görüntüle();
    }

    @PostMapping
    public Paket kaydet(@RequestBody Paket paket) {
        return paketService.kaydet(paket);
    }
}
