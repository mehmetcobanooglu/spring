package com.mehmet.oyunmagazasi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.oyunmagazasi.entity.Yapimci;
import com.mehmet.oyunmagazasi.repository.YapimciRepository;

@Service
public class YapimciService {

    private final YapimciRepository yapimciRepository;

    public YapimciService(YapimciRepository yapimciRepository) {
        this.yapimciRepository = yapimciRepository;
    }

    public List<Yapimci> tümünüGetir() {
        return yapimciRepository.findAll();
    }

    public Yapimci kaydet(Yapimci yapimci) {
        return yapimciRepository.save(yapimci);
    }
}
