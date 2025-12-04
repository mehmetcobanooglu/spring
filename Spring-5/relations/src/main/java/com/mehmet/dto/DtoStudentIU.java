package com.mehmet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = " first name alanı boş bırakılamaz ")
    @Min(value = 3)
    @Max(value = 10)
    // @Size(min = 3, max = 10, message = "firstName uzunluğu 3 ile 10 karakter
    // arasında olmalı")

    private String firstName;

    @Size(min = 3, max = 30)
    private String lastName;
    private String birthOfDate;
    @Email(message = "email formatinda giriniz.")
    private String email;

    @Size(min = 11, max = 11, message = "tckn alanı 11 karakter olmalıdır")
    @NotEmpty(message = "tckn alanı boş geçilemez")

    private String tckn;

}
