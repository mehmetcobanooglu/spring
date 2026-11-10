package com.sporsalonu.yonetim.dto;

import com.sporsalonu.yonetim.entity.Odeme;
import com.sporsalonu.yonetim.entity.Uyelik;

public record UyelikOdemeRequest(Uyelik uyelik,
        Odeme odeme) {

}
