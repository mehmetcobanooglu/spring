package com.sporsalonu.yonetim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sporsalonu.yonetim.entity.Odeme;
import com.sporsalonu.yonetim.entity.Uyelik;
import com.sporsalonu.yonetim.repository.OdemeRepository;
import com.sporsalonu.yonetim.repository.UyelikRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
public class UyelikService {

    private final UyelikRepository uyelikRepository;

    private final OdemeRepository odemeRepository;

    public UyelikService(UyelikRepository uyelikRepository, OdemeRepository odemeRepository) {
        this.uyelikRepository = uyelikRepository;
        this.odemeRepository = odemeRepository;
    }

    public List<Uyelik> tümünüGetir() {
        return uyelikRepository.findAll();
    }

    public Uyelik kaydet(Uyelik uyelik) {
        return uyelikRepository.save(uyelik);
    }

    @Transactional
    public void uyelikOlustur(Uyelik uyelik, Odeme odeme) {

        uyelikRepository.saveAndFlush(uyelik);

        odeme.setUyelik(uyelik);
        odeme.setUye(uyelik.getUye());

        odemeRepository.saveAndFlush(odeme);

        throw new RuntimeException("Ödeme işlemi başarısız!");
    }
}
