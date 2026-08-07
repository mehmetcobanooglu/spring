package com.api.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateRequestDto {

    @NotBlank(message = "İsim Boş Birakilamaz")
    private String name;

    @Email(message = "Geçerli Bir E-Mail Giriniz")
    @NotBlank(message = "Email Boş Birakilamaz")
    private String email;

    @NotBlank(message = "Şifre Boş Birakilamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmali")
    private String password;

    public UserCreateRequestDto() {
    };

    public UserCreateRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
