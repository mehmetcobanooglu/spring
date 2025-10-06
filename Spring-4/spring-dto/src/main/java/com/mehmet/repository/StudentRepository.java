package com.mehmet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mehmet.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // HQL : SINIFIN İSMİ VE DEĞİŞKENLER KULLANILARAK SORGULAR YAZILIR
    /*
     * @Query(value = "FROM Student", nativeQuery = false)
     * List<Student> findAllStudents();
     */

    // SQL : TABLO İSMİ VE TABLO İÇERİSİNDEKİ KOLON İSİMLERİYLE SORGULAR YAZILIR

    @Query(value = "select*from student", nativeQuery = true)
    List<Student> findAllStudents();
}
