package com.sporsalonu.yonetim.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/ara")
    public List<Uye> adaGoreGetir(@RequestParam String ad) {
        return uyeService.adaGoreGetir(ad);
    }

    @GetMapping("/yasindan-buyuk")
    public List<Uye> yasaGoreListele(@RequestParam Integer yas) {
        return uyeService.yasaGoreGetir(yas);
    }

    @GetMapping("/yas-araligi")
    public List<Uye> yasAraliginaGöreGetir(@RequestParam Integer minYas, @RequestParam Integer maxYas) {
        return uyeService.yasAraliginaGoreGetir(minYas, maxYas);
    }

    @GetMapping("/epostasi-olanlar")
    public List<Uye> epostasiOlanlarGetir() {
        return uyeService.epostasiOlanlariGetir();
    }

    @GetMapping("/epostasi-olmayanlar")
    public List<Uye> epostasiOlmayanlariGetir() {
        return uyeService.epostasiOlmayanlariGetir();
    }

    @GetMapping("/ad-soyad")
    public List<Uye> adVeSoyadaGoreGetir(@RequestParam String ad, @RequestParam String soyad) {
        return uyeService.adaVeSoyadaGoreGetir(ad, soyad);
    }

    @GetMapping("/ad-soyad-veya")
    public List<Uye> adVeyaSoyadaGoreGetir(@RequestParam String ad, @RequestParam String soyad) {
        return uyeService.adVeyaSoyadaGoreGetir(ad, soyad);
    }

    @GetMapping("/yasaGoreKucuktur")
    public List<Uye> yasaGoreKucuktur(@RequestParam Integer yas) {
        return uyeService.yasaGoreKucukturBul(yas);
    }

    @GetMapping("/yasaGoreKucukVeyaEsitBul")
    public List<Uye> yasaGoreKucukVeyaEsitBul(@RequestParam Integer yas) {
        return uyeService.yasaGoreKucukVeyaEsitBul(yas);
    }

    @GetMapping("/adla-baslayanlar")
    public List<Uye> adaBaslayanlar(@RequestParam String ad) {
        return uyeService.adaGoreBaslayanlariGetir(ad);
    }

    @GetMapping("/adla-bitenler")
    public List<Uye> adlaBitenler(@RequestParam String ad) {
        return uyeService.adaGoreBitenleriGetir(ad);
    }

    @GetMapping("/uyan-yaslar")
    public List<Uye> uyanYaslar(@RequestParam List<Integer> yaslar) {
        return uyeService.uyanYaslariGetir(yaslar);
    }

    @GetMapping("uymayan-yas")
    public List<Uye> uymayanYas(@RequestParam Integer yas) {
        return uyeService.uymayanYasiGetir(yas);
    }

    @GetMapping("/ada-gore-tekrarsiz")
    public List<Uye> adaGoreTekrarsizGetir(@RequestParam String ad) {
        return uyeService.adaGoreTekrarsizGetir(ad);
    }

    @GetMapping("/en-genc")
    public Uye enGencUyeyiGetir() {
        return uyeService.enGencUyeyiGetir();
    }

    @GetMapping("/en-yasli-uc")
    public List<Uye> enYasliUcUyeyiGetir() {
        return uyeService.enYasliUcUyeyiGetir();
    }

    @GetMapping("/sirala")
    public List<Uye> sirala(
            @RequestParam(defaultValue = "yas") String alan,
            @RequestParam(defaultValue = "asc") String yon) {
        return uyeService.sirala(alan, yon);
    }

    @GetMapping("/sayfala")
    public Page<Uye> sayfala(@RequestParam int sayfa, @RequestParam int boyut) {
        return uyeService.uyeleriSayfala(sayfa, boyut);
    }

    @GetMapping("/query/yas-buyuk-esit")
    public List<Uye> yasiBuyukVeyaEsitUyeBul(@RequestParam Integer yas) {
        return uyeService.yasiBuyukVeyaEsitUyeBul(yas);
    }

    @GetMapping("/pakete-gore")
    public List<Uye> paketeGore(@RequestParam String paketAdi) {
        return uyeService.findUyelerByPaketAdi(paketAdi);
    }

    @GetMapping("/aktif-uyeligi-olanlar")
    public List<Uye> aktifUyelik() {
        return uyeService.aktifOlanUyeler();
    }

    @GetMapping("/aktif-uyeler-yas")
    public List<Uye> findYasiBuyukAktifUyeler(@RequestParam Integer yas) {
        return uyeService.findYasiBuyukAktifUyeler(yas);
    }

    @GetMapping("/aktif-pakete-gore")
    public List<Uye> findAktifUyelerByPaketAdi(@RequestParam String paketAdi) {
        return uyeService.findAktifUyelerByPaketAdi(paketAdi);
    }

    @GetMapping("/uyeligi-olmayanlar")
    public List<Uye> findUyeligiOlmayanUyeler() {
        return uyeService.findUyeligiOlmayanUyeler();
    }

    @GetMapping("/fetch-uyelikler")
    public List<Uye> findUyelerWithUyelikler() {
        return uyeService.findUyelerWithUyelikler();
    }

    @GetMapping("/fetch-uyelikler-paket")
    public List<Uye> findUyelerWithUyeliklerAndPaket() {
        return uyeService.findUyelerWithUyeliklerAndPaket();
    }

    @GetMapping("/yas-email")
    public List<Uye> findYasiEsitVeEmail(
            @RequestParam Integer yas,
            @RequestParam String email) {
        return uyeService.findYasiEsitVeEmail(yas, email);
    }

    @GetMapping("/yas-araligi-disinda")
    public List<Uye> findKucukDegerBuyukDeger() {
        return uyeService.findKucukDegerBuyukDeger();
    }
}
