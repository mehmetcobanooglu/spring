package com.sporsalonu.yonetim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporsalonu.yonetim.entity.Uye;
import com.sporsalonu.yonetim.service.UyeService;

@RestController
@RequestMapping("/uyeler")
public class UyeController {

    private final UyeService uyeService;

    public UyeController(UyeService uyeService) {
        this.uyeService = uyeService;
    }

    @GetMapping
    public List<Uye> getir() {
        return uyeService.tümünüGetir();
    }

    @PostMapping
    public Uye kaydet(@RequestBody Uye uye) {

        return uyeService.save(uye);
    }

}
