package com.jpa.jpa_performans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.jpa.jpa_performans.entity.Musteri;

public interface MusteriRepository extends JpaRepository<Musteri, Long> {

    @Query("""
            SELECT DISTINCT m
            FROM Musteri m
            LEFT JOIN FETCH m.siparisler
            """)
    List<Musteri> musterileriSiparislerleGetir();

    @EntityGraph(attributePaths = { "siparisler" })
    @Query("SELECT m FROM Musteri m")
    List<Musteri> entityGraphIleGetir();

    Page<Musteri> findAll(Pageable pageable);
}
