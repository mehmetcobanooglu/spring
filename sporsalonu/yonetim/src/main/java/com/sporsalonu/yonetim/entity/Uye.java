
package com.sporsalonu.yonetim.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Uye {

    public Uye() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private Integer yas;

    @OneToMany(mappedBy = "uye")
    @JsonManagedReference("uye-uyelikler")
    private List<Uyelik> uyelikler;

    @OneToMany(mappedBy = "uye")
    @JsonManagedReference("uye-odemeler")
    private List<Odeme> odemeler;
}
