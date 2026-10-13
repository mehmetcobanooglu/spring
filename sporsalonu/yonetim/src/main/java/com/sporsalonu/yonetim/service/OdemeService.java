
package com.sporsalonu.yonetim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sporsalonu.yonetim.entity.Odeme;
import com.sporsalonu.yonetim.repository.OdemeRepository;

@Service
public class OdemeService {

    private final OdemeRepository odemeRepository;

    public OdemeService(OdemeRepository odemeRepository) {
        this.odemeRepository = odemeRepository;
    }

    public List<Odeme> tumunuGetir() {
        return odemeRepository.findAll();
    }

    public Odeme kaydet(Odeme odeme) {
        return odemeRepository.save(odeme);
    }

}