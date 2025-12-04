package com.mehmet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress {

    private Long id;

    private String description;

    private DtoCustomer customer;
}
