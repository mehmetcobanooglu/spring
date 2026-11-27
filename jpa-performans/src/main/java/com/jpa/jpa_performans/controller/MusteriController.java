package com.jpa.jpa_performans.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpa_performans.entity.Musteri;
import com.jpa.jpa_performans.service.MusteriService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/musteriler")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;

    @GetMapping
    public List<Musteri> tumMusterileriGetir() {
        return musteriService.tumMusterileriGetir();
    }

    @PostMapping
    public Musteri musteriEkle(@RequestBody Musteri musteri) {
        return musteriService.musteriEkle(musteri);
    }

    @GetMapping("/siparislerle")
    public List<Musteri> siparislerleGetir() {
        return musteriService.tumMusterileriSiparisleriyleGetir();
    }

    @GetMapping("/entity-graph")
    public List<Musteri> entityGraphIleGetir() {
        return musteriService.entityGraphIleGetir();
    }

    @GetMapping("/batch-test")
    public List<Musteri> batchFetchTest() {
        return musteriService.batchFetchTest();
    }

    @PutMapping("/persistence/{id}")
    public Musteri persistenceContext(@PathVariable Long id) {
        return musteriService.persistenceContext(id);
    }

    @PutMapping("/dirty-checking/{id}")
    public String dirtyCheckingTest(@PathVariable Long id) {
        return musteriService.dirtyCheckingTest(id);
    }

    @PutMapping("/detached-test/{id}")
    public String detachedDirtyCheckingTest(@PathVariable Long id) {
        return musteriService.detachedDirtyCheckingTest(id);
    }

    @PutMapping("/merge-test/{id}")
    public String mergeTest(@PathVariable Long id) {
        return musteriService.mergeTest(id);
    }

    @PutMapping("/flush-test/{id}")
    public String flushTest(@PathVariable Long id) {
        return musteriService.flushTest(id);
    }

    @PutMapping("/clear-test/{id}")
    public String clearTest(@PathVariable Long id) {
        return musteriService.clearTest(id);
    }

    @PutMapping("/flush-clear-test/{id}")
    public String flushClearTest(@PathVariable Long id) {
        return musteriService.flushClearTest(id);
    }

    @GetMapping("/first-level-cache")
    public void firstLevelCacheTest() {
        musteriService.firstLevelCacheTest();
    }
}
