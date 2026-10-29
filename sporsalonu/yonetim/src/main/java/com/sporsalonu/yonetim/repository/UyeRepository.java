package com.sporsalonu.yonetim.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sporsalonu.yonetim.entity.Odeme;
import com.sporsalonu.yonetim.entity.Paket;
import com.sporsalonu.yonetim.entity.Uye;
import com.sporsalonu.yonetim.entity.Uyelik;

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

        @Query("select u from Uye u " + "where u.yas < 18  OR u.yas > 40 ")
        List<Uye> findKucukDegerBuyukDeger();

        @Query("select u from Uye u " + "where u.yas BETWEEN :minYas AND :maxYas")
        List<Uye> findBetweenArasiDegerBul(@Param("minYas") Integer minYas, @Param("maxYas") Integer maxYas);

        @Query("select u from Uye u " + "where u.ad LIKE  CONCAT(:ad, '%')")
        List<Uye> findSiralamaliBul(@Param("ad") String ad);

        @Query("select u from Uye u " + "ORDER BY u.ad ASC")
        List<Uye> findUyelerAdaGoreSirali();

        @Query("select u from Uye u " + "ORDER BY u.yas DESC")
        List<Uye> findYasaGoreAzalanSirali();

        @Query("select u from Uye u " + "ORDER BY u.yas DESC, u.ad ASC")
        List<Uye> findUyelerYasVeAdaGoreSirali();

        @Query("select p from Paket p " + "ORDER BY p.fiyat ASC")
        List<Paket> findPaketleriFiyataGoreSirali();

        @Query("select u from Uye u " + "ORDER BY u.soyad ASC , u.yas ASC")
        List<Uye> findUyelerSoyadVeYaslarinaGoreSirali();

        // Count ve Group By
        @Query("Select COUNT(u) from Uye u")
        Long countAllUyeler();

        @Query("Select uy.paket, COUNT(uy) " + "FROM Uyelik uy " + "GROUP BY uy.paket")
        List<Object[]> countUyeliklerPaketeGore();

        @Query("select u.yas, COUNT(u) " + "FROM Uye u " + "GROUP BY u.yas")
        List<Object[]> countUyelerYasaGore();

        @Query("select p.fiyat, Count(p) " + "from Paket p " + "Group By p.fiyat")
        List<Object[]> countPaketlerFiyataGore();

        @Query("select uy.aktif, Count(uy) " + "from Uyelik uy " + "GROUP BY uy.aktif")
        List<Object[]> countUyeliklerAktiflikDurumunaGore();

        @Query("select uy.baslangicTarihi, Count(uy) " + "from Uyelik uy " + "GROUP BY uy.baslangicTarihi")
        List<Object[]> countUyeliklerBaslangicTarihineGore();

        @Query("select o.odemeYontemi, Count(o) " + "from Odeme o " + "GROUP BY o.odemeYontemi")
        List<Object[]> countOdemelerYontemeGore();

        @Query("SELECT o.odemeDurumu, COUNT(o) " +
                        "FROM Odeme o " +
                        "GROUP BY o.odemeDurumu")
        List<Object[]> countOdemelerDurumaGore();

        @Query("select o.odemeYontemi, o.odemeDurumu, Count(o)" + "FROM Odeme o "
                        + "GROUP BY o.odemeYontemi ,o.odemeDurumu")
        List<Object[]> countOdemelerYontemVeDurumaGore();

        // HAVING

        @Query("select o.odemeYontemi, Count(o) " + "FROM Odeme o " + "GROUP BY o.odemeYontemi "
                        + " HAVING COUNT(o) > 5 ")
        List<Object[]> countOdemelerYontemeGore2();

        @Query("select u.yas , Count(u) " + "FROM Uye u " + "GROUP BY u.yas " + "HAVING COUNT(u) > 3")
        List<Object[]> countUyelerYasaGore2();

        @Query("select p.fiyat , Count(p) " + "FROM Paket p " + "GROUP BY p.fiyat " + "HAVING COUNT(p) > 2 ")
        List<Object[]> counttPaketlerFiyataGore();

        @Query("select p.fiyat, COUNT(p) " + "FROM Paket p " + "GROUP BY p.fiyat " + "HAVING COUNT(p) > 2")
        List<Object[]> countPaketlerFiyataGorre();

        @Query("select uy.aktif, Count(uy) " + "FROM Uyelik uy " + "GROUP BY uy.aktif " + "HAVING COUNT(uy) > 10")
        List<Object[]> countUyelikAktifligeGore();

        @Query("select o.odemeYontemi, COUNT(o) " + "FROM Odeme o " + "GROUP BY o.odemeYontemi "
                        + "HAVING COUNT(o) >= 5 ")
        List<Object[]> countOdemelerYontemeGore3();

        @Query("select o.odemeYontemi ,o.odemeDurumu " + "from Odeme o " + "Group by o.odemeYontemi, o.odemeDurumu "
                        + "having Count(o) > 5")
        List<Object[]> countOdemelerYontemVeDurumaGore2();

        @Query("select u.yas, Count(u) " + "from Uye u " + "Group By  u.yas " + "Having Count(u) >= 4")
        List<Object[]> countUyelerYasaGoreFinal();

        @Query("select SUM(o.tutar) from Odeme o ")
        BigDecimal toplamOdemeTutari();

        @Query("select AVG(o.tutar) from Odeme o")
        Double ortalamaOdemeTutari();

        @Query("select SUM(p.fiyat) from Paket p")
        Double toplamPaketFiyati();

        @Query("select AVG(p.fiyat) from Paket p")
        Double ortalamaPaketFiyati();

        @Query("SELECT MIN(p.fiyat) FROM Paket p")
        Double enDusukPaketFiyati();

        @Query("SELECT MIN(o.tutar) FROM Odeme o")
        BigDecimal enDusukOdemeTutari();

        @Query("SELECT MAX(p.fiyat) FROM Paket p")
        Double enYuksekPaketFiyati();

        @Query("SELECT MAX(o.tutar) FROM Odeme o")
        BigDecimal enYuksekOdemeTutari();

        @Query("SELECT SUM(o.tutar) FROM Odeme o")
        BigDecimal toplamOdemeTutarii();

        @Query("SELECT AVG(o.tutar) FROM Odeme o")
        Double ortalamaOdemeTutarii();

        @Query("SELECT MIN(p.fiyat), MAX(p.fiyat), AVG(p.fiyat) FROM Paket p")
        List<Object[]> paketFiyatIstatistikleri();

        @Query("SELECT SUM(o.tutar), MIN(o.tutar), MAX(o.tutar), AVG(o.tutar) FROM Odeme o")
        List<Object[]> odemeIstatistikleri();

        @Query("select p from Paket p " + "where p.fiyat > " + "(select AVG(p2.fiyat) from Paket p2)")
        List<Paket> ortalamaFiyattanPahaliPaketler();

        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat < " +
                        "(SELECT MAX(p2.fiyat) FROM Paket p2)")
        List<Paket> enPahaliPakettenUcuzPaketler();

        @Query("select u From Uye u " + "where u.yas > " + "(Select AVG(u2.yas) from Uye u2)")
        List<Uye> ortalamaYastanBuyukUyeler();

        @Query("select p from  Paket p " + "where p.fiyat = " + "(Select MIN(p2.fiyat) FROM Paket p2)")
        List<Paket> enUcuzPaketler();

        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat < " +
                        "(SELECT SUM(p2.fiyat) / 2 FROM Paket p2)")
        List<Paket> toplamFiyatYarisindanDusukPaketler();

        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat < " +
                        "(SELECT MAX(p2.fiyat) FROM Paket p2)")
        List<Paket> enPahaliPakettenUcuzPaketlerr();

        @Query("SELECT o FROM Odeme o " +
                        "WHERE o.tutar > " +
                        "(SELECT AVG(o2.tutar) FROM Odeme o2)")
        List<Odeme> ortalamaTutardanYuksekOdemeler();

        @Query("select u FROM Uye u " + "where exist " + "(select o from Odeme o Where o.uye = u)")
        List<Uye> odemesiOlanUyeler();

        @Query("select u From Uye u " + "where NOT EXISTS " + "(select o from Odeme o where o.uye = u)")
        List<Uye> odemesiBulunmayanUyeler();

        @Query("select p from Paket p " + "WHERE NOT EXISTS " + "(select uy from Uyelik uy where uy.paket = p)")
        List<Paket> uyeligiOlmayanPaketler();

        @Query("select uy from Uyelik uy " + "where not exists " + "(select o from Odeme o where o.uyelik = uy)")
        List<Uyelik> odemesiOlmayanUyelikler();

        @Query("select u From Uye u " + "where exists " + "(select uy from Uyelik uy where uy.uye = u)")
        List<Uye> uyeligiOlanUyeler();

        @Query("select u from Uye u " + "where not exists " + "(select uy From Uyelik uy where uy.uye = u)")
        List<Uye> uyeligiOlmayanUyeler();

        @Query("SELECT uy FROM Uyelik uy " +
                        "WHERE EXISTS " +
                        "(SELECT o FROM Odeme o WHERE o.uyelik = uy)")
        List<Uyelik> enAzBirOdemesiOlanUyelikler();

        @Query("select uy From Uyelik uy " + "where not exists " + "(select o From Odeme o where o.uyelik = uy)")
        List<Uyelik> hicOdemesiOlmayanUyelikler();

        @Query("select p From Paket p " + "where p.fiyat IN(500,1000,1500)")
        List<Paket> belirliFiyatlardakiPaketler();

        @Query("select p From Paket p " + "where p.fiyat NOT IN(500, 1000,1500,2000)")
        List<Paket> belirliFiyatlarDisindakiPaketler();

        @Query("select uy From Uyelik uy " + "where uy.uye.id IN " + "(SELECT o.uye.id From Odeme o)")
        List<Uyelik> odemeYapanUyelerinUyelikleri();

        @Query("select uy From Uyelik uy " + "where u.uy.id NOT IN " + "(SELECT o.uye.id From Odeme o)")
        List<Uyelik> odemeYapmayanUyelerinUyelikleri();

        @Query("select p From Paket p " + "where p.fiyat IN " + "(SELECT MAX(p2.fiyat) From Paket p2 )")
        List<Paket> enPahaliFiyattakiPaketler();

        @Query("SELECT p FROM Paket p " +
                        "WHERE p.id NOT IN " +
                        "(SELECT uy.paket.id FROM Uyelik uy)")
        List<Paket> uyeligiOlmayanPaketlerr();

        @Query("SELECT uy FROM Uyelik uy " +
                        "WHERE uy.uye.email IN " +
                        "(SELECT o.uye.email FROM Odeme o)")
        List<Uyelik> odemeYapanUyelerinUyeliklerii();

        @Query("SELECT uy FROM Uyelik uy " +
                        "WHERE uy.uye.id NOT IN " +
                        "(SELECT o.uye.id FROM Odeme o)")
        List<Uyelik> odemeYapmayanUyelerinUyeliklerii();

        @Query("select u from Uye u " + "where u.telefon IS NULL")
        List<Uye> telefonNumarasiOlmayanUyeler();

        @Query("SELECT u FROM Uye u WHERE u.telefon IS NOT NULL")
        List<Uye> telefonNumarasiOlanUyeler();

        @Query("select uy FROM Uyelik uy where u.uy IS NULL")
        List<Uye> uyeligiOlmayanUyelerr();
}