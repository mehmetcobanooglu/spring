package com.mehmet.controller;

import com.mehmet.dto.DtoAddress;

public interface IAddressController {

    public DtoAddress findAddressById(Long id);

}
