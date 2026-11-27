package com.jpa.jpa_performans.service;

import java.util.List;

import org.hibernate.engine.spi.EntityEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    public String flushTest(Long id) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi"));

        musteri.setName("flush test");
        System.out.println("İsim Değiştirildi");

        entityManager.flush();
        System.out.println("flush gerçekleştirildi");
        return "flush test başarili: " + musteri.getName();
    }

    @Transactional
    public String clearTest(Long id) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow(() -> new RuntimeException("müşteri bulunamadi"));
        System.out.println("Clear Öncesi: " + entityManager.contains(musteri));
        musteri.setName("Clear Test");

        entityManager.clear();

        System.out.println("Clear sonrasi: " + entityManager.contains(musteri));
        return "Clear Test Tamamlandi";
    }

    @Transactional
    public String flushClearTest(Long id) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow(() -> new RuntimeException("müşteri bulunamadi"));
        musteri.setName("flush clear test");

        entityManager.flush();

        System.out.println("flush yapildi");

        entityManager.clear();

        System.out.println("clear yapildi");

        return "flush ve clear tamamlandi";
    }

    @Transactional
    public void firstLevelCacheTest() {
        Musteri musteri1 = musteriRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Müşteri Bulunamadı"));
        System.out.println("Birinci sorgu tamamlandı.");
        Musteri musteri2 = musteriRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Müşteri Bulunamadı"));
        System.out.println("İkinci sorgu tamamlandı.");

        System.out.println("Aynı nesne mi: " + (musteri1 == musteri2));
    }

    @Transactional
    public Musteri musteriGetir(Long id) {
        return musteriRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void cacheTest() {

        Musteri musteri1 = musteriRepository.findById(1L).orElseThrow();
        System.out.println("1.Transaction:" + musteri1.getName());

    }

    public Page<Musteri> musterileriSayfaliGetir() {
        Pageable pageable = PageRequest.of(1, 5);
        return musteriRepository.findAll(pageable);
    }
}
