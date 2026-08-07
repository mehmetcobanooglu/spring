package com.yemektarifi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yemektarifi.app.entity.YemekTarifi;
import com.yemektarifi.app.service.YemekTarifiService;

@RestController
@RequestMapping("/tarifler")
public class YemekTarifiController {

    @Autowired
    private YemekTarifiService service;

    @GetMapping
    public List<YemekTarifi> tumTarifleriGetir() {
        return service.tumTarifleriGetir();
    }

    @GetMapping("/{id}")
    public YemekTarifi tarifGetir(@PathVariable Long id) {
        return service.tarifGetir(id);
    }

    @PostMapping
    public YemekTarifi tarifEkle(@RequestBody YemekTarifi tarif) {
        return service.tarifEkle(tarif);
    }

    @DeleteMapping("/{id}")
    public String tarifSil(@PathVariable Long id) {

        service.tarifSil(id);
        return "Tarif Başariyle Silindi";
    }

}
