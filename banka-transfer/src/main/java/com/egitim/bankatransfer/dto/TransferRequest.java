package com.egitim.bankatransfer.dto;

import java.math.BigDecimal;

public record TransferRequest(
        Long gonderenId,
        Long aliciId,
        BigDecimal tutar) {

}
