package com.mehmet.oyunmagazasi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.oyunmagazasi.service.SiparisService;
import com.mehmet.oyunmagazasi.entity.Siparis;

@RequestMapping("/siparisler")
@RestController
public class SiparisController {

    private final SiparisService siparisService;

    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }

    @GetMapping
    public List<Siparis> siparisGöster() {
        return siparisService.tümünüGetir();
    }
}
