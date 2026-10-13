package com.sporsalonu.yonetim.service;

import com.sporsalonu.yonetim.entity.Paket;
import com.sporsalonu.yonetim.repository.PaketRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PaketService {

    private final PaketRepository paketRepository;

    public PaketService(PaketRepository paketRepository) {

        this.paketRepository = paketRepository;
    }

    public List<Paket> görüntüle() {
        return paketRepository.findAll();
    }

    public Paket kaydet(Paket paket) {
        return paketRepository.save(paket);
    }
}
