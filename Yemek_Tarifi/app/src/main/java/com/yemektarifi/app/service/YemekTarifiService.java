package com.yemektarifi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemektarifi.app.entity.YemekTarifi;
import com.yemektarifi.app.repository.YemekTarifiRepository;

@Service
public class YemekTarifiService {

    @Autowired
    private YemekTarifiRepository yemektarifi;

    public List<YemekTarifi> tumTarifleriGetir() {
        return yemektarifi.findAll();
    }

    public YemekTarifi tarifGetir(Long id) {
        return yemektarifi.findById(id).orElse(null);
    }

    public YemekTarifi tarifEkle(YemekTarifi tarif) {
        return yemektarifi.save(tarif);
    }

    public void tarifSil(Long id) {
        yemektarifi.deleteById(id);
    }
}
