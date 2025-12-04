package com.mehmet.services;

import com.mehmet.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);
}
