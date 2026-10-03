package com.mehmet.oyunmagazasi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.oyunmagazasi.repository.SiparisRepository;
import com.mehmet.oyunmagazasi.entity.Siparis;

@Service
public class SiparisService {

    private final SiparisRepository siparisRepository;

    public SiparisService(SiparisRepository siparisRepository) {
        this.siparisRepository = siparisRepository;
    }

    public List<Siparis> tümünüGetir() {
        return siparisRepository.findAll();
    }
}
