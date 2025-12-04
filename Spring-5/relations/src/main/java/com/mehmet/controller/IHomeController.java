package com.mehmet.controller;

import com.mehmet.dto.DtoHome;

public interface IHomeController {
    public DtoHome findHomeById(Long id);
}
