
package com.sporsalonu.yonetim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sporsalonu.yonetim.entity.Uye;

public interface UyeRepository extends JpaRepository<Uye, Long> {

    // SPRING DATA JPA HAZIR METOTLARI

    List<Uye> findByAdContainingIgnoreCase(String ad);

    List<Uye> findByYasGreaterThan(Integer yas);

    List<Uye> findAllByOrderByYasAsc();

    List<Uye> findAllByOrderByYasDesc();

    List<Uye> findByYasBetween(Integer minYas, Integer maxYas);

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

    // WHERE VE PARAMETRE KULLANIMI

    @Query("SELECT u FROM Uye u WHERE u.yas >= :yas")
    List<Uye> yasiBuyukVeyaEsitUyeBul(@Param("yas") Integer yas);

    @Query("SELECT u FROM Uye u WHERE u.yas >= :yas AND u.email = :email")
    List<Uye> findYasiEsitVeEmail(
            @Param("yas") Integer yas,
            @Param("email") String email);

    @Query("SELECT u FROM Uye u WHERE u.yas < 18 OR u.yas > 40")
    List<Uye> findKucukDegerBuyukDeger();

    @Query("SELECT u FROM Uye u WHERE u.yas BETWEEN :minYas AND :maxYas")
    List<Uye> findBetweenArasiDegerBul(
            @Param("minYas") Integer minYas,
            @Param("maxYas") Integer maxYas);

    @Query("SELECT u FROM Uye u WHERE u.ad LIKE CONCAT(:ad, '%')")
    List<Uye> findSiralamaliBul(@Param("ad") String ad);

    // JOIN

    // Paket adına göre üyeleri getir
    @Query("SELECT u FROM Uye u " +
            "JOIN u.uyelikler uy " +
            "JOIN uy.paket p " +
            "WHERE p.paketAdi = :paketAdi")
    List<Uye> findUyelerByPaketAdi(@Param("paketAdi") String paketAdi);

    // Aktif üyeliği olan üyeler
    @Query("SELECT u FROM Uye u " +
            "JOIN u.uyelikler uy " +
            "WHERE uy.aktif = true")
    List<Uye> findUyelerWithListAktifUyelik();

    // Belirli yaştan büyük ve aktif üyeliği olan üyeler
    @Query("SELECT u FROM Uye u " +
            "JOIN u.uyelikler uy " +
            "WHERE u.yas >= :yas AND uy.aktif = true")
    List<Uye> findYasiBuyukAktifUyeler(@Param("yas") Integer yas);

    // Belirli pakete sahip aktif üyeler
    @Query("SELECT u FROM Uye u " +
            "JOIN u.uyelikler uy " +
            "JOIN uy.paket p " +
            "WHERE p.paketAdi = :paketAdi AND uy.aktif = true")
    List<Uye> findAktifUyelerByPaketAdi(@Param("paketAdi") String paketAdi);

    // LEFT JOIN

    // Üyeliği olmayan üyeler
    @Query("SELECT u FROM Uye u " +
            "LEFT JOIN u.uyelikler uy " +
            "WHERE uy IS NULL")
    List<Uye> findUyeligiOlmayanUyeler();

    // JOIN FETCH

    // Üyeleri üyelikleriyle birlikte getir
    @Query("SELECT u FROM Uye u JOIN FETCH u.uyelikler")
    List<Uye> findUyelerWithUyelikler();

    // Üyeleri üyelikleri ve paketleriyle birlikte getir
    @Query("SELECT u FROM Uye u " +
            "JOIN FETCH u.uyelikler uy " +
            "JOIN FETCH uy.paket")
    List<Uye> findUyelerWithUyeliklerAndPaket();

    // ORDER BY

    // Ada göre artan sıralama
    @Query("SELECT u FROM Uye u ORDER BY u.ad ASC")
    List<Uye> findUyelerAdaGoreSirali();

    // Yaşa göre azalan sıralama
    @Query("SELECT u FROM Uye u ORDER BY u.yas DESC")
    List<Uye> findYasaGoreAzalanSirali();

    // Yaşa göre azalan, ada göre artan sıralama
    @Query("SELECT u FROM Uye u ORDER BY u.yas DESC, u.ad ASC")
    List<Uye> findUyelerYasVeAdaGoreSirali();

    // Soyada ve yaşa göre artan sıralama
    @Query("SELECT u FROM Uye u ORDER BY u.soyad ASC, u.yas ASC")
    List<Uye> findUyelerSoyadVeYaslarinaGoreSirali();

    // COUNT VE GROUP BY

    // Toplam üye sayısı
    @Query("SELECT COUNT(u) FROM Uye u")
    Long countAllUyeler();

    // Üyeleri yaşlarına göre grupla ve say
    @Query("SELECT u.yas, COUNT(u) FROM Uye u GROUP BY u.yas")
    List<Object[]> countUyelerYasaGore();

    // HAVING

    // Aynı yaş grubunda 3'ten fazla üye olan gruplar
    @Query("SELECT u.yas, COUNT(u) FROM Uye u " +
            "GROUP BY u.yas HAVING COUNT(u) > 3")
    List<Object[]> countUyelerYasaGore2();

    // SUBQUERY

    // Ortalama yaştan büyük üyeler
    @Query("SELECT u FROM Uye u " +
            "WHERE u.yas > (SELECT AVG(u2.yas) FROM Uye u2)")
    List<Uye> ortalamaYastanBuyukUyeler();

    // EXISTS

    // En az bir ödemesi olan üyeler
    @Query("SELECT u FROM Uye u " +
            "WHERE EXISTS (SELECT o FROM Odeme o WHERE o.uye = u)")
    List<Uye> odemesiOlanUyeler();

    // En az bir üyeliği olan üyeler
    @Query("SELECT u FROM Uye u " +
            "WHERE EXISTS (SELECT uy FROM Uyelik uy WHERE uy.uye = u)")
    List<Uye> uyeligiOlanUyeler();

    // NOT EXISTS

    // Hiç ödemesi olmayan üyeler
    @Query("SELECT u FROM Uye u " +
            "WHERE NOT EXISTS (SELECT o FROM Odeme o WHERE o.uye = u)")
    List<Uye> odemesiBulunmayanUyeler();

    // Hiç üyeliği olmayan üyeler
    @Query("SELECT u FROM Uye u " +
            "WHERE NOT EXISTS (SELECT uy FROM Uyelik uy WHERE uy.uye = u)")
    List<Uye> uyeligiOlmayanUyeler();

    // IS NULL

    // Telefon numarası olmayan üyeler
    @Query("SELECT u FROM Uye u WHERE u.telefon IS NULL")
    List<Uye> telefonNumarasiOlmayanUyeler();

    // IS NOT NULL

    // Telefon numarası olan üyeler
    @Query("SELECT u FROM Uye u WHERE u.telefon IS NOT NULL")
    List<Uye> telefonNumarasiOlanUyeler();

    // IS EMPTY

    // Üyelik listesi boş olan üyeler
    @Query("SELECT u FROM Uye u WHERE u.uyelikler IS EMPTY")
    List<Uye> uyeligiOlmayanUyeler2();

    // Görev: Üyeleri yaşlarına göre sınıflandırmak istiyoruz.

    // CASE → Koşullu işlemi başlatır.
    // WHEN → Koşulu belirtir.
    // THEN → Koşul doğruysa döndürülecek değeri belirtir.
    // ELSE → Hiçbir koşul sağlanmazsa döndürülecek değerdir.
    // - END → CASE bloğunu bitirir.
    @Query("""
                SELECT u.ad,
                       u.yas,
                       CASE
                           WHEN u.yas < 18 THEN 'Reşit Değil'
                           ELSE 'Reşit'
                       END
                FROM Uye u
            """)
    List<Object[]> uyeleriYasinaGoreSiniflandir();

    // Üyeleri yaşlarına göre üç gruba ayır:

    /*
     * 18 yaşından küçük → Çocuk
     * 18–30 yaş arası → Genç
     * 30 yaşından büyük → Yetişkin
     */
    @Query("""
            SELECT u.ad, u.yas,
            CASE
                WHEN u.yas < 18 THEN 'Çocuk'
                WHEN u.yas <= 30 THEN 'Genç'
                ELSE 'Yetişkin'
            END
            FROM Uye u
            """)
    List<Object[]> yasaGoreGrupla();

    // Üyeleri yaşlarına göre sınıflandır:
    /*
     * 18'den küçük → Çocuk
     * 
     * 
     * 
     * 18–25 → Genç
     * 
     * 
     * 
     * 26–40 → Orta Yaş
     * 
     * 
     * 
     * 40'tan büyük → İleri Yaş
     */

    @Query("""
            SELECT u.yas, u.ad,
            CASE
                WHEN u.yas < 18 THEN 'Çocuk'
                WHEN u.yas < 26 THEN 'genç'
                WHEN u.yas < 40 THEN 'orta yas'
                ELSE 'ileri yas'
            END
            FROM Uye u
            """)
    List<Object[]> uyeleriYasinaGore();

    @Query("""
                Select  u.ad, COALESCE(u.email, 'e.mail Adresi Yok') FROM Uye u
            """)
    List<Object[]> uyeleriEmailIleGetir();

    @Query("""
             Select u.ad, COALESCE(u.telefon, 'Telefon Numarasi Yok') From Uye u
            """)
    List<Object[]> uyeleriTelefonlariniGetir();

}
