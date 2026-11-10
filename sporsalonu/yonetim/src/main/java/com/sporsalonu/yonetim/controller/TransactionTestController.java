package com.sporsalonu.yonetim.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporsalonu.yonetim.dto.UyelikOdemeRequest;
import com.sporsalonu.yonetim.service.UyelikService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor

public class TransactionTestController {

    private final UyelikService uyelikService;

    @PostMapping("/transaction")
    public ResponseEntity<String> testTransaction(@RequestBody UyelikOdemeRequest request) {
        uyelikService.uyelikOlustur(request.uyelik(), request.odeme());
        return ResponseEntity.ok("işlem başarili");
    }
}
