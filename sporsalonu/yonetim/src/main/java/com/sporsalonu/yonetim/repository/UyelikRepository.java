
package com.sporsalonu.yonetim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sporsalonu.yonetim.entity.Uyelik;

public interface UyelikRepository extends JpaRepository<Uyelik, Long> {

        // GROUP BY

        // Üyelikleri paketlerine göre grupla ve say
        @Query("""
                        SELECT uy.paket, COUNT(uy)
                        FROM Uyelik uy
                        GROUP BY uy.paket
                        """)
        List<Object[]> countUyeliklerPaketeGore();

        // Üyelikleri aktiflik durumuna göre grupla
        @Query("""
                        SELECT uy.aktif, COUNT(uy)
                        FROM Uyelik uy
                        GROUP BY uy.aktif
                        """)
        List<Object[]> countUyeliklerAktiflikDurumunaGore();

        // Üyelikleri başlangıç tarihine göre grupla
        @Query("""
                        SELECT uy.baslangicTarihi, COUNT(uy)
                        FROM Uyelik uy
                        GROUP BY uy.baslangicTarihi
                        """)
        List<Object[]> countUyeliklerBaslangicTarihineGore();

        // HAVING

        // 10'dan fazla üyeliği bulunan aktiflik grupları
        @Query("""
                        SELECT uy.aktif, COUNT(uy)
                        FROM Uyelik uy
                        GROUP BY uy.aktif
                        HAVING COUNT(uy) > 10
                        """)
        List<Object[]> countUyelikAktifligeGore();

        // EXISTS

        // En az bir ödemesi bulunan üyelikler
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE EXISTS (
                            SELECT o
                            FROM Odeme o
                            WHERE o.uyelik = uy
                        )
                        """)
        List<Uyelik> enAzBirOdemesiOlanUyelikler();

        // NOT EXISTS

        // Hiç ödemesi bulunmayan üyelikler
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE NOT EXISTS (
                            SELECT o
                            FROM Odeme o
                            WHERE o.uyelik = uy
                        )
                        """)
        List<Uyelik> hicOdemesiOlmayanUyelikler();

        // IN

        // Ödeme yapan üyelerin üyelikleri
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE uy.uye.id IN (
                            SELECT o.uye.id
                            FROM Odeme o
                        )
                        """)
        List<Uyelik> odemeYapanUyelerinUyelikleri();

        // NOT IN

        // Ödeme yapmayan üyelerin üyelikleri
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE uy.uye.id NOT IN (
                            SELECT o.uye.id
                            FROM Odeme o
                        )
                        """)
        List<Uyelik> odemeYapmayanUyelerinUyelikleri();

        // IS EMPTY

        // Hiç ödemesi olmayan üyelikler
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE uy.odemeler IS EMPTY
                        """)
        List<Uyelik> odemesiOlmayanUyelikler();

        // IS NOT EMPTY

        // En az bir ödemesi olan üyelikler
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE uy.odemeler IS NOT EMPTY
                        """)
        List<Uyelik> odemesiOlanUyelikler();

        // CASE WHEN

        // Üyelikleri aktiflik durumuna göre sınıflandır
        @Query("""
                        SELECT uy.aktif,
                        CASE
                            WHEN uy.aktif = true THEN 'Aktif Üyelik'
                            ELSE 'Pasif Üyelik'
                        END
                        FROM Uyelik uy
                        """)
        List<Object[]> uyelikleriDurumunaGoreSiniflandir();

        // Birden fazla koşulla sınıflandırma
        @Query("""
                        SELECT uy.aktif,
                        CASE
                            WHEN uy.aktif = true
                                 AND uy.baslangicTarihi IS NOT NULL
                                THEN 'AKTİF VE BAŞLAMIŞ'
                            WHEN uy.aktif = false
                                THEN 'PASİF'
                            ELSE 'Kontrol Edilecek'
                        END
                        FROM Uyelik uy
                        """)
        List<Object[]> uyelikDurumlariniSiniflandir();

        // COALESCE

        // Başlangıç tarihi NULL ise 0L döndür
        @Query("""
                        SELECT uy.baslangicTarihi,
                               COALESCE(uy.baslangicTarihi, 0L)
                        FROM Uyelik uy
                        """)
        List<Object[]> uyelikBaslangicTarihleriniGetir();

        // NULLIF

        // Ödeme durumu ÖDENDİ ise NULL döndür
        @Query("""
                        SELECT o.odemeDurumu,
                               NULLIF(o.odemeDurumu, 'ÖDENDİ')
                        FROM Odeme o
                        """)
        List<Object[]> odemeDurumlariniGetir();

        // ORDER BY

        // Aktif üyelikleri başlangıç tarihine göre yeniden sırala
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE uy.aktif = true
                        ORDER BY uy.baslangicTarihi DESC
                        """)
        List<Uyelik> uyelikleriYenidenSirala();

        // Aktif olmayan üyelikler
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE uy.aktif = false
                        """)
        List<Uyelik> aktifOlmayanUyelikler();

        // COUNT

        // Toplam üyelik sayısı
        @Query("""
                        SELECT COUNT(uy)
                        FROM Uyelik uy
                        """)
        Long uyelikSayisi();

        // NOT EXISTS

        // Ödemesi bulunmayan üyelikler
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE NOT EXISTS (
                            SELECT o.id
                            FROM Odeme o
                            WHERE o.uyelik = uy
                        )
                        """)
        List<Uyelik> odemesiBulunmayanUyelikler();

        // Aynı sorgunun diğer metot adıyla kullanımı
        @Query("""
                        SELECT uy
                        FROM Uyelik uy
                        WHERE NOT EXISTS (
                            SELECT o
                            FROM Odeme o
                            WHERE o.uyelik = uy
                        )
                        """)
        List<Uyelik> odemesiolmayanuyelik();
}
