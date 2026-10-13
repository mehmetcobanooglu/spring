package com.sporsalonu.yonetim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sporsalonu.yonetim.entity.Uye;
import com.sporsalonu.yonetim.repository.UyeRepository;

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
}
