package com.jpa.jpa_performans.service;

import java.util.List;

import org.hibernate.engine.spi.EntityEntry;
import org.springframework.stereotype.Service;

import com.jpa.jpa_performans.entity.Musteri;
import com.jpa.jpa_performans.repository.MusteriRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusteriService {

    private final MusteriRepository musteriRepository;

    public List<Musteri> tumMusterileriGetir() {
        return musteriRepository.findAll();
    }

    public Musteri musteriEkle(Musteri musteri) {
        return musteriRepository.save(musteri);
    }

    // public List<Musteri> tumMusterileriSiparisleriyleGetir() {

    // List<Musteri> musteriler = musteriRepository.findAll();

    // for (Musteri musteri : musteriler) {
    // System.out.println(
    // musteri.getName() + " - Sipariş Sayısı: " + musteri.getSiparisler().size());
    // }
    // return musteriler;
    // }

    public List<Musteri> tumMusterileriSiparisleriyleGetir() {
        return musteriRepository.musterileriSiparislerleGetir();
    }

    public List<Musteri> entityGraphIleGetir() {
        return musteriRepository.entityGraphIleGetir();
    }

    public List<Musteri> batchFetchTest() {

        List<Musteri> musteriler = musteriRepository.findAll();

        for (Musteri musteri : musteriler) {
            System.out.println(musteri.getName() + "- Siparis Sayisi : " + musteri.getSiparisler().size());

        }
        return musteriler;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Musteri persistenceContext(Long id) {

        Musteri musteri = musteriRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi"));

        System.out.println("İlk durum: " + entityManager.contains(musteri));

        entityManager.detach(musteri);

        System.out.println("Detach sonrası: " + entityManager.contains(musteri));

        musteri.setName("Detach Test");

        return musteri;
    }

    @Transactional
    public String dirtyCheckingTest(Long id) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi"));

        System.out.println("Managed mi ? " + entityManager.contains(musteri));

        musteri.setName("Dirty Checking Test");

        System.out.println("isim değiştirildi");

        return "isim değiştirildi" + musteri.getName();
    }

    @Transactional
    public String detachedDirtyCheckingTest(Long id) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi"));

        System.out.println("Detach öncesi: " + entityManager.contains(musteri));

        entityManager.detach(musteri);

        System.out.println("Detach Sonrasi: " + entityManager.contains(musteri));
        musteri.setName("Detached Test");

        return "İsim Değiştirildi: " + musteri.getName();
    }

    @Transactional
    public String mergeTest(Long id) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi"));

        entityManager.detach(musteri);

        System.out.println("Detached: " + entityManager.contains(musteri));
        musteri.setName("Merge ile güncellendi");
        Musteri managedMusteri = entityManager.merge(musteri);

        System.out.println("Orijinal Name : " + entityManager.contains(musteri));
        System.out.println("Merge sonrasi nesne: " + entityManager.contains(managedMusteri));

        return "Merge tamamlandı: " + managedMusteri.getName();

    }
}
