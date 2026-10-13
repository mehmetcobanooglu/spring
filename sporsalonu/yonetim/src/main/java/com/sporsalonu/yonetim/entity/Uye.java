package com.sporsalonu.yonetim.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Uye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String ad;

    private String soyad;

    private String email;

    private String telefon;

    private Integer yas;

    @OneToMany(mappedBy = "uye")
    @JsonManagedReference
    private List<Uyelik> uyelikler;

    @OneToMany(mappedBy = "uye")
    @JsonManagedReference
    private List<Odeme> odemeler;
}
