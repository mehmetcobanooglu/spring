package com.mehmet.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    @Column(nullable = false)
    private Boolean tamamlandi = false;

    public void setTamamlandi(Boolean tamamlandi) {
        // Eğer JSON null gönderirse default false ata
        this.tamamlandi = (tamamlandi != null) ? tamamlandi : false;
    }
}
