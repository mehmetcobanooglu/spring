package com.sporsalonu.yonetim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sporsalonu.yonetim.entity.Uye;

public interface UyeRepository extends JpaRepository<Uye, Long> {
    List<Uye> findByAdContainingIgnoreCase(String ad);

    List<Uye> findByYasGreaterThan(Integer yas);

    List<Uye> findAllByOrderByYasAsc();

    List<Uye> findAllByOrderByYasDesc();

    List<Uye> findByYasBetween(
            Integer minYas,
            Integer maxYas);

    List<Uye> findByAdNot(String ad);

    List<Uye> findByEmailIsNotNull();

    List<Uye> findByEmailIsNull();

    List<Uye> findByAdAndSoyad(String ad, String soyad);

    List<Uye> findByAdOrSoyad(String ad, String soyad);

    List<Uye> findByYasLessThan(Integer yas);

    List<Uye> findByYasLessThanEqual(Integer yas);

    List<Uye> findByAdStartingWith(String ad);

    List<Uye> findByAdEndingWith(String ad);

    List<Uye> findByYasIn(List<Integer> yaslar);

    List<Uye> findByYasNot(Integer yas);

    List<Uye> findDistinctByAd(String ad);

    Uye findFirstByOrderByYasAsc();

    List<Uye> findTop3ByOrderByYasDesc();

    @Query("SELECT u FROM Uye u WHERE u.yas >= :yas")
    List<Uye> yasiBuyukVeyaEsitUyeBul(@Param("yas") Integer yas);

    @Query("SELECT u FROM Uye u " + "JOIN u.uyelikler uy " + "JOIN uy.paket p " + "WHERE p.paketAdi = :paketAdi")
    List<Uye> findUyelerByPaketAdi(@Param("paketAdi") String paketAdi);

    @Query("Select u From Uye u " + "JOIN u.uyelikler uy " + "where uy.aktif = true")
    List<Uye> findUyelerWithListAktifUyelik();

    @Query("SELECT u FROM Uye u " + "JOIN u.uyelikler uy " + "WHERE u.yas >= :yas AND uy.aktif = true")
    List<Uye> findYasiBuyukAktifUyeler(@Param("yas") Integer yas);

    @Query("SELECT u FROM Uye u " + "JOIN u.uyelikler uy " + "JOIN uy.paket p "
            + "WHERE p.paketAdi = :paketAdi AND uy.aktif = true")
    List<Uye> findAktifUyelerByPaketAdi(@Param("paketAdi") String paketAdi);

    @Query("SELECT u FROM Uye u " + "left join u.uyelikler uy " + "where uy is null")
    List<Uye> findUyeligiOlmayanUyeler();

    @Query("SELECT u FROM Uye u JOIN FETCH u.uyelikler")
    List<Uye> findUyelerWithUyelikler();

    @Query("SELECT u FROM Uye u " + "JOIN FETCH u.uyelikler uy " + "JOIN FETCH uy.paket")
    List<Uye> findUyelerWithUyeliklerAndPaket();

    @Query("select u from Uye u " + "where u.yas >= :yas")
    List<Uye> findYasiEsitVeyaBuyukUye(@Param("yas") Integer yas);

    @Query("select u from Uye u " +
            "where u.yas >= :yas AND u.email = :email")
    List<Uye> findYasiEsitVeEmail(
            @Param("yas") Integer yas,
            @Param("email") String email);
}