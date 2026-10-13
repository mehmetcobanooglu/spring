package com.sporsalonu.yonetim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporsalonu.yonetim.entity.Odeme;
import com.sporsalonu.yonetim.service.OdemeService;

@RestController
@RequestMapping("/odemeler")
public class OdemeController {

    private final OdemeService odemeService;

    public OdemeController(OdemeService odemeService) {
        this.odemeService = odemeService;
    }

    @GetMapping
    public List<Odeme> getir() {
        return odemeService.tumunuGetir();
    }

    @PostMapping
    public Odeme kaydet(@RequestBody Odeme odeme) {
        return odemeService.kaydet(odeme);
    }
}