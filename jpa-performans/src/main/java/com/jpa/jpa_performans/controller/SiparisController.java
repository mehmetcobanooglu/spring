package com.jpa.jpa_performans.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpa_performans.entity.Siparis;
import com.jpa.jpa_performans.service.SiparisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/siparisler")
@RequiredArgsConstructor
public class SiparisController {

    private final SiparisService siparisService;

    @PostMapping("/musteri/{musteriId}")
    public Siparis siparisEkle(
            @PathVariable Long musteriId,
            @RequestBody Siparis siparis) {

        return siparisService.siparisEkle(musteriId, siparis);
    }
}
