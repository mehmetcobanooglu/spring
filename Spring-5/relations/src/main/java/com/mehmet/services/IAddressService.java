package com.mehmet.services;

import com.mehmet.dto.DtoAddress;

public interface IAddressService {

    DtoAddress findAddressById(Long id);

}
