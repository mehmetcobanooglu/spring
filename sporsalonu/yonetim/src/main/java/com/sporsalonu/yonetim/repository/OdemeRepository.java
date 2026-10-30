
package com.sporsalonu.yonetim.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sporsalonu.yonetim.entity.Odeme;

public interface OdemeRepository extends JpaRepository<Odeme, Long> {

    // GROUP BY

    // Ödeme yöntemine göre ödeme sayısı
    @Query("SELECT o.odemeYontemi, COUNT(o) FROM Odeme o GROUP BY o.odemeYontemi")
    List<Object[]> countOdemelerYontemeGore();

    // Ödeme durumuna göre ödeme sayısı
    @Query("SELECT o.odemeDurumu, COUNT(o) FROM Odeme o GROUP BY o.odemeDurumu")
    List<Object[]> countOdemelerDurumaGore();

    // Ödeme yöntemi ve durumuna göre ödeme sayısı
    @Query("SELECT o.odemeYontemi, o.odemeDurumu, COUNT(o) " +
            "FROM Odeme o GROUP BY o.odemeYontemi, o.odemeDurumu")
    List<Object[]> countOdemelerYontemVeDurumaGore();

    // HAVING

    // Ödeme yöntemi bazında 5'ten fazla ödeme olan gruplar
    @Query("SELECT o.odemeYontemi, COUNT(o) " +
            "FROM Odeme o GROUP BY o.odemeYontemi HAVING COUNT(o) > 5")
    List<Object[]> countOdemelerYontemeGore2();

    // Ödeme yöntemi bazında en az 5 ödeme olan gruplar
    @Query("SELECT o.odemeYontemi, COUNT(o) " +
            "FROM Odeme o GROUP BY o.odemeYontemi HAVING COUNT(o) >= 5")
    List<Object[]> countOdemelerYontemeGore3();

    // Ödeme yöntemi ve durumuna göre 5'ten fazla ödeme olan gruplar
    @Query("SELECT o.odemeYontemi, o.odemeDurumu " +
            "FROM Odeme o GROUP BY o.odemeYontemi, o.odemeDurumu " +
            "HAVING COUNT(o) > 5")
    List<Object[]> countOdemelerYontemVeDurumaGore2();

    // AGGREGATE FUNCTIONS

    // Toplam ödeme tutarı
    @Query("SELECT SUM(o.tutar) FROM Odeme o")
    BigDecimal toplamOdemeTutari();

    // Ortalama ödeme tutarı
    @Query("SELECT AVG(o.tutar) FROM Odeme o")
    Double ortalamaOdemeTutari();

    // En düşük ödeme tutarı
    @Query("SELECT MIN(o.tutar) FROM Odeme o")
    BigDecimal enDusukOdemeTutari();

    // En yüksek ödeme tutarı
    @Query("SELECT MAX(o.tutar) FROM Odeme o")
    BigDecimal enYuksekOdemeTutari();

    // Ödeme istatistikleri
    @Query("SELECT SUM(o.tutar), MIN(o.tutar), MAX(o.tutar), AVG(o.tutar) FROM Odeme o")
    List<Object[]> odemeIstatistikleri();

    // SUBQUERY

    // Ortalama ödeme tutarından yüksek ödemeler
    @Query("SELECT o FROM Odeme o " +
            "WHERE o.tutar > (SELECT AVG(o2.tutar) FROM Odeme o2)")
    List<Odeme> ortalamaTutardanYuksekOdemeler();

    // IS NULL / IS NOT NULL

    // Ödeme tarihi dolu olan ödemeler
    @Query("SELECT o FROM Odeme o WHERE o.odemeTarihi IS NOT NULL")
    List<Odeme> odemeTarihiOlanOdemeler();

}
