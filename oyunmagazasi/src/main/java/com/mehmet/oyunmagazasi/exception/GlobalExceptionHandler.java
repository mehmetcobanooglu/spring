package com.mehmet.oyunmagazasi.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> hatalar = new LinkedHashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {

            hatalar.put(error.getField(), error.getDefaultMessage());
        }

        return hatalar;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(KullaniciBulunamadiException.class)
    public Map<String, String> kullaniciBulunamadiException(KullaniciBulunamadiException es) {
        Map<String, String> kullaniciHatasi = new LinkedHashMap<>();

        kullaniciHatasi.put("hata", es.getMessage());
        return kullaniciHatasi;
    }
}