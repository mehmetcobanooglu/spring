package com.mehmet.oyunmagazasi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.oyunmagazasi.service.OyunService;
import com.mehmet.oyunmagazasi.entity.Oyun;

@RestController
@RequestMapping("/oyunlar")
public class OyunController {

    private final OyunService oyunService;

    public OyunController(OyunService oyunService) {
        this.oyunService = oyunService;
    }

    @GetMapping
    public List<Oyun> getir() {
        return oyunService.tümünüGetir();
    }

    @PostMapping
    public Oyun save(@RequestBody Oyun oyun) {
        return oyunService.kaydet(oyun);
    }

    @PostMapping("/{oyun_ID}/yapimci/{yapimci_ID}")
    public Oyun savee(@PathVariable Long oyun_ID, @PathVariable Long yapimci_ID) {
        return oyunService.yapimciAta(oyun_ID, yapimci_ID);
    }

    @PostMapping("/{oyun_ID}/kategori/{kategori_ID}")
    public Oyun kategoriAta(@PathVariable Long oyun_ID, @PathVariable Long kategori_ID) {
        return oyunService.kategoriAta(oyun_ID, kategori_ID);
    }
}
