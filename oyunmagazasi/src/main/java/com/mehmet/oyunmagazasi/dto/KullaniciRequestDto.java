package com.mehmet.oyunmagazasi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class KullaniciRequestDto {

    @NotBlank(message = "Ad Boş Birakilamaz")
    private String ad;
    @NotBlank(message = "Soyad Boş Birakilamaz")
    private String soyad;
    @NotBlank(message = "Telefon Numarasi Boş Birakilmaz")
    private String telefonNumarasi;
    @NotBlank(message = "E-Mail Boş Birakilmaz")
    @Email(message = "Geçerli Mail Giriniz")
    private String email;
    @NotNull(message = "Yaş Boş Birakilmaz")
    @Min(value = 18, message = "Yaş 18'den Küçük Olamaz")
    private Integer yas;
}
