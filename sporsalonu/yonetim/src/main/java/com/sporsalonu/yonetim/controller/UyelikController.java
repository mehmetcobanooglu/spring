package com.sporsalonu.yonetim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporsalonu.yonetim.entity.Uyelik;
import com.sporsalonu.yonetim.service.UyelikService;

@RestController
@RequestMapping("/uyelikler")
public class UyelikController {

    private final UyelikService uyelikService;

    public UyelikController(UyelikService uyelikService) {
        this.uyelikService = uyelikService;
    }

    @GetMapping
    public List<Uyelik> getir() {
        return uyelikService.tümünüGetir();
    }

    @PostMapping
    public Uyelik kaydetme(@RequestBody Uyelik uyelik) {
        return uyelikService.kaydet(uyelik);
    }
}
