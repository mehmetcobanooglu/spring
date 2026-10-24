package com.sporsalonu.yonetim.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.sporsalonu.yonetim.entity.Uye;
import com.sporsalonu.yonetim.repository.UyeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Service
public class UyeService {

    private final UyeRepository uyeRepository;

    public UyeService(UyeRepository uyeRepository) {
        this.uyeRepository = uyeRepository;
    }

    public List<Uye> tümünüGetir() {
        return uyeRepository.findAll();
    }

    public Uye save(Uye uye) {
        return uyeRepository.save(uye);
    }

    public List<Uye> adaGoreGetir(String ad) {
        return uyeRepository.findByAdContainingIgnoreCase(ad);
    }

    public List<Uye> yasaGoreGetir(Integer yas) {
        return uyeRepository.findByYasGreaterThan(yas);
    }

    public List<Uye> yasAraliginaGoreGetir(Integer minYas, Integer maxYas) {
        return uyeRepository.findByYasBetween(minYas, maxYas);
    }

    public List<Uye> epostasiOlanlariGetir() {
        return uyeRepository.findByEmailIsNotNull();
    }

    public List<Uye> epostasiOlmayanlariGetir() {
        return uyeRepository.findByEmailIsNull();
    }

    public List<Uye> adaVeSoyadaGoreGetir(String ad, String soyad) {
        return uyeRepository.findByAdAndSoyad(ad, soyad);
    }

    public List<Uye> adVeyaSoyadaGoreGetir(String ad, String soyad) {
        return uyeRepository.findByAdOrSoyad(ad, soyad);
    }

    public List<Uye> yasaGoreKucukturBul(Integer yas) {
        return uyeRepository.findByYasLessThan(yas);
    }

    public List<Uye> yasaGoreKucukVeyaEsitBul(Integer yas) {
        return uyeRepository.findByYasLessThanEqual(yas);
    }

    public List<Uye> adaGoreBaslayanlariGetir(String ad) {
        return uyeRepository.findByAdStartingWith(ad);
    }

    public List<Uye> adaGoreBitenleriGetir(String ad) {
        return uyeRepository.findByAdEndingWith(ad);
    }

    public List<Uye> uyanYaslariGetir(List<Integer> yaslar) {
        return uyeRepository.findByYasIn(yaslar);
    }

    public List<Uye> uymayanYasiGetir(Integer yas) {
        return uyeRepository.findByYasNot(yas);
    }

    public List<Uye> adaGoreTekrarsizGetir(String ad) {
        return uyeRepository.findDistinctByAd(ad);
    }

    public Uye enGencUyeyiGetir() {
        return uyeRepository.findFirstByOrderByYasAsc();
    }

    public List<Uye> enYasliUcUyeyiGetir() {
        return uyeRepository.findTop3ByOrderByYasDesc();
    }

    public List<Uye> sirala(String alan, String yon) {
        Sort sort;

        if (yon.equalsIgnoreCase("desc")) {
            sort = Sort.by(alan).descending();
        } else {
            sort = Sort.by(alan).ascending();
        }

        return uyeRepository.findAll(sort);
    }

    public Page<Uye> uyeleriSayfala(int sayfa, int boyut) {

        Pageable pageable = PageRequest.of(sayfa, boyut);
        return uyeRepository.findAll(pageable);
    }

    public List<Uye> yasiBuyukVeyaEsitUyeBul(Integer yas) {
        return uyeRepository.yasiBuyukVeyaEsitUyeBul(yas);
    }

    public List<Uye> findUyelerByPaketAdi(String paketAdi) {
        return uyeRepository.findUyelerByPaketAdi(paketAdi);
    }

    public List<Uye> aktifOlanUyeler() {
        return uyeRepository.findUyelerWithListAktifUyelik();
    }

    public List<Uye> findYasiBuyukAktifUyeler(Integer yas) {
        return uyeRepository.findYasiBuyukAktifUyeler(yas);
    }

    public List<Uye> findAktifUyelerByPaketAdi(String paketAdi) {
        return uyeRepository.findAktifUyelerByPaketAdi(paketAdi);
    }

    public List<Uye> findUyeligiOlmayanUyeler() {
        return uyeRepository.findUyeligiOlmayanUyeler();
    }

    public List<Uye> findUyelerWithUyelikler() {
        return uyeRepository.findUyelerWithUyelikler();
    }

    public List<Uye> findUyelerWithUyeliklerAndPaket() {
        return uyeRepository.findUyelerWithUyeliklerAndPaket();
    }

    public List<Uye> findYasiEsitVeyaBuyukUye(Integer yas) {
        return uyeRepository.findYasiEsitVeyaBuyukUye(yas);
    }

    public List<Uye> findYasiEsitVeEmail(Integer yas, String email) {
        return uyeRepository.findYasiEsitVeEmail(yas, email);
    }

    public List<Uye> findKucukDegerBuyukDeger() {
        return uyeRepository.findKucukDegerBuyukDeger();
    }

}
