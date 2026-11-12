package com.egitim.bankatransfer.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egitim.bankatransfer.dto.TransferRequest;
import com.egitim.bankatransfer.entity.Hesap;
import com.egitim.bankatransfer.service.HesapService;

@RestController
@RequestMapping("/api/")
public class HesapController {

    private final HesapService hesapService;

    public HesapController(HesapService hesapService) {
        this.hesapService = hesapService;
    }

    @GetMapping("/hesap")
    public List<Hesap> hesaplariListele() {
        return hesapService.hesaplariListele();
    }

    @PostMapping("/hesap")
    public Hesap hesapOlustur(@RequestBody Hesap hesap) {
        return hesapService.hesapOlustur(hesap);
    }

    @PostMapping("/transfer")
    public String paraTransferi(@RequestBody TransferRequest request) {
        hesapService.paraTransferi(request.gonderenId(), request.aliciId(), request.tutar());

        return "Para Transferi Başarili";
    }

    @PostMapping("/para-yatir/{hesapId}")
    public Hesap paraYatirma(@PathVariable Long hesapId, @RequestParam BigDecimal tutar) {
        return hesapService.paraYatir(hesapId, tutar);
    }

    @PostMapping("/para-cekme/{hesapId}")
    public Hesap paraCekme(@PathVariable Long hesapId, @RequestParam BigDecimal tutar) {
        return hesapService.paraCek(hesapId, tutar);

    }
}
