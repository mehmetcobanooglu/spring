
package com.sporsalonu.yonetim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sporsalonu.yonetim.entity.Paket;

public interface PaketRepository extends JpaRepository<Paket, Long> {

        // ORDER BY

        // Paketleri fiyatlarına göre artan sırala
        @Query("SELECT p FROM Paket p ORDER BY p.fiyat ASC")
        List<Paket> findPaketleriFiyataGoreSirali();

        // GROUP BY

        // Paketleri fiyatlarına göre grupla ve say
        @Query("SELECT p.fiyat, COUNT(p) FROM Paket p GROUP BY p.fiyat")
        List<Object[]> countPaketlerFiyataGore();

        // HAVING

        // Aynı fiyata sahip 2'den fazla paket bulunan gruplar
        @Query("SELECT p.fiyat, COUNT(p) FROM Paket p " +
                        "GROUP BY p.fiyat HAVING COUNT(p) > 2")
        List<Object[]> countPaketlerFiyataGore2();

        // AGGREGATE FUNCTIONS

        // Paket fiyatlarının toplamı
        @Query("SELECT SUM(p.fiyat) FROM Paket p")
        Double toplamPaketFiyati();

        // Paket fiyatlarının ortalaması
        @Query("SELECT AVG(p.fiyat) FROM Paket p")
        Double ortalamaPaketFiyati();

        // En düşük paket fiyatı
        @Query("SELECT MIN(p.fiyat) FROM Paket p")
        Double enDusukPaketFiyati();

        // En yüksek paket fiyatı
        @Query("SELECT MAX(p.fiyat) FROM Paket p")
        Double enYuksekPaketFiyati();

        // Paket fiyat istatistikleri
        @Query("SELECT MIN(p.fiyat), MAX(p.fiyat), AVG(p.fiyat) FROM Paket p")
        List<Object[]> paketFiyatIstatistikleri();

        // SUBQUERY

        // Ortalama fiyattan pahalı paketler
        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat > (SELECT AVG(p2.fiyat) FROM Paket p2)")
        List<Paket> ortalamaFiyattanPahaliPaketler();

        // En pahalı paketten ucuz paketler
        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat < (SELECT MAX(p2.fiyat) FROM Paket p2)")
        List<Paket> enPahaliPakettenUcuzPaketler();

        // En ucuz paketler
        // En ucuz paketler
        @Query(value = """
                        SELECT *
                        FROM paket
                        WHERE fiyat = (
                            SELECT MIN(fiyat)
                            FROM paket
                        )
                        """, nativeQuery = true)
        List<Paket> enUcuzPaketler();

        // Toplam paket fiyatının yarısından düşük paketler
        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat < (SELECT SUM(p2.fiyat) / 2 FROM Paket p2)")
        List<Paket> toplamFiyatYarisindanDusukPaketler();

        // IN / NOT IN

        // Belirli fiyatlardaki paketler
        @Query("SELECT p FROM Paket p WHERE p.fiyat IN (500, 1000, 1500)")
        List<Paket> belirliFiyatlardakiPaketler();

        // Belirli fiyatlar dışındaki paketler
        @Query("SELECT p FROM Paket p WHERE p.fiyat NOT IN (500, 1000, 1500, 2000)")
        List<Paket> belirliFiyatlarDisindakiPaketler();

        // En pahalı fiyattaki paketler
        @Query("SELECT p FROM Paket p " +
                        "WHERE p.fiyat IN (SELECT MAX(p2.fiyat) FROM Paket p2)")
        List<Paket> enPahaliFiyattakiPaketler();

        // Üyeliği bulunmayan paketler
        @Query("SELECT p FROM Paket p " +
                        "WHERE p.id NOT IN (SELECT uy.paket.id FROM Uyelik uy)")
        List<Paket> uyeligiOlmayanPaketler();

        // IS EMPTY

        // Üyelik listesi boş olan paketler
        @Query("SELECT p FROM Paket p WHERE p.uyelikler IS EMPTY")
        List<Paket> uyeligiOlmayanPaketler2();

        @Query("""
                        SELECT NULLIF(p.fiyat, 0)
                        FROM Paket p
                        """)
        List<Double> sifirdanFarkliDeger();

        @Query("""
                        SELECT NULLIF(p.fiyat, 500)
                        FROM Paket p
                        """)
        List<Double> paketMevcutDeger();

        @Query("""
                        SELECT COALESCE(NULLIF(p.fiyat, 500), 0)
                        FROM Paket p
                        """)
        List<Double> nullifCoalesceKullanimi();

        @Query("Select p From Paket p " + "WHERE p.fiyat< 1000 ORDER BY p.fiyat DESC")
        List<Paket> bindenKucukSirala();

        @Query("select p from Paket p " + "where p.fiyat BETWEEN 500 and 1500")
        List<Paket> arasindaDegerBul();

        @Query("select MAX(p.fiyat) From Paket p")
        Double enPahali();

        @Query("select p.fiyat, AVG(p.fiyat) From Paket p GROUP BY p.fiyat HAVING AVG(p.fiyat) > 1000  ")
        List<Object[]> paketOrtalamaFiyatlari();

        @Query("select p From Paket p WHERE p.fiyat > (select AVG(p2.fiyat) from Paket p2)")
        List<Paket> ortalamaPaketAlistirmasi();

        @Query("Select p From Paket p WHERE p.fiyat = (select MAX(p2.fiyat) From Paket p2)")
        List<Paket> enpahaliPAKET();

}
