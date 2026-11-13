package com.egitim.bankatransfer.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.egitim.bankatransfer.entity.Hesap;
import com.egitim.bankatransfer.repository.HesapRepository;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HesapService {

    private final HesapRepository hesapRepository;

    // Para Yatır
    public Hesap paraYatir(Long hesapId, BigDecimal tutar) {
        Hesap hesap = hesapRepository.findById(hesapId).orElseThrow(() -> new RuntimeException("Hesap Bulunamadi"));

        if (tutar.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Yatirilacak Tutar Sifirdan Büyük Olmalidir.");
        }

        hesap.setBakiye(hesap.getBakiye().add(tutar));

        return hesapRepository.save(hesap);
    }

    // Para Çekme
    public Hesap paraCek(Long hesapId, BigDecimal tutar) {
        Hesap hesap = hesapRepository.findById(hesapId).orElseThrow(() -> new RuntimeException("Hesap Bulunamadi"));

        if (tutar.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Çekilecek Tutar Sifirdan Büyük Olmalidir.");
        }

        if (hesap.getBakiye().compareTo(tutar) < 0) {
            throw new RuntimeException("Yetersiz Bakiye");
        }

        hesap.setBakiye(hesap.getBakiye().subtract(tutar));
        return hesapRepository.save(hesap);
    }

    // Para Transferi
    @Transactional
    public void paraTransferi(Long gonderenId, Long aliciId, BigDecimal tutar) {
        Hesap gonderen = hesapRepository.findById(gonderenId)
                .orElseThrow(() -> new RuntimeException("Gönderen Hesap Bulunamadi"));
        Hesap alici = hesapRepository.findById(aliciId)
                .orElseThrow(() -> new RuntimeException("Alici Hesap Bulunamadi"));

        if (tutar.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Transfer tutari sifirdan büyük olmalidir.");
        }

        if (gonderen.getBakiye().compareTo(tutar) < 0) {
            throw new RuntimeException("Yetersiz Bakiye");
        }

        if (gonderenId.equals(aliciId)) {
            throw new RuntimeException("Aynı hesaba para transferi yapılamaz.");
        }

        gonderen.setBakiye(gonderen.getBakiye().subtract(tutar));
        alici.setBakiye(alici.getBakiye().add(tutar));

        hesapRepository.save(gonderen);
        hesapRepository.save(alici);

        // throw new RuntimeException("Test Hatasi : RollBack!");
    }

    public List<Hesap> hesaplariListele() {
        return hesapRepository.findAll();
    }

    public Hesap hesapOlustur(Hesap hesap) {
        return hesapRepository.save(hesap);
    }

}
