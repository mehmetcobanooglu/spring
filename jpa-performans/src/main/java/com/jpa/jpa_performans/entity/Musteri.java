package com.jpa.jpa_performans.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "musteriler")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String soyad;
    private String email;

    @JsonManagedReference
    // İlişkili verileri yüklerken mümkün olduğunda 5'li gruplar hâlinde getir.
    @BatchSize(size = 5)
    @OneToMany(mappedBy = "musteri", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Siparis> siparisler = new ArrayList<>();

}
