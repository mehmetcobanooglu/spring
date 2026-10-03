package com.mehmet.oyunmagazasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mehmet.oyunmagazasi.entity.Oyun;

public interface OyunRepository extends JpaRepository<Oyun, Long> {

}
