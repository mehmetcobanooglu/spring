package com.jpa.jpa_performans.service;

import org.springframework.stereotype.Service;

import com.jpa.jpa_performans.entity.Musteri;
import com.jpa.jpa_performans.entity.Siparis;
import com.jpa.jpa_performans.repository.MusteriRepository;
import com.jpa.jpa_performans.repository.SiparisRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class SiparisService {

    private final SiparisRepository siparisRepository;
    private final MusteriRepository musteriRepository;

    public Siparis siparisEkle(Long musteriId, Siparis siparis) {
        Musteri musteri = musteriRepository.findById(musteriId)
                .orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi."));

        siparis.setMusteri(musteri);
        return siparisRepository.save(siparis);
    }
}
