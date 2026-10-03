package com.mehmet.oyunmagazasi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.oyunmagazasi.entity.Yapimci;
import com.mehmet.oyunmagazasi.service.YapimciService;

@RequestMapping("/yapimcilar")
@RestController
public class YapimciController {

    private final YapimciService yapimciService;

    public YapimciController(YapimciService yapimciService) {
        this.yapimciService = yapimciService;
    }

    @GetMapping
    public List<Yapimci> tümünüGetir() {
        return yapimciService.tümünüGetir();
    }

    @PostMapping
    public Yapimci ekle(@RequestBody Yapimci yapimci) {
        return yapimciService.kaydet(yapimci);
    }

}
