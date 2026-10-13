package com.sporsalonu.yonetim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sporsalonu.yonetim.entity.Uyelik;
import com.sporsalonu.yonetim.repository.UyelikRepository;

@Service
public class UyelikService {

    private final UyelikRepository uyelikRepository;

    public UyelikService(UyelikRepository uyelikRepository) {
        this.uyelikRepository = uyelikRepository;
    }

    public List<Uyelik> tümünüGetir() {
        return uyelikRepository.findAll();
    }

    public Uyelik kaydet(Uyelik uyelik) {
        return uyelikRepository.save(uyelik);
    }
}
