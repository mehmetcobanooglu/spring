package com.yemektarifi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yemektarifi.app.entity.YemekTarifi;

public interface YemekTarifiRepository extends JpaRepository<YemekTarifi, Long> {

    List<YemekTarifi> findByKategori(String kategori);

}
