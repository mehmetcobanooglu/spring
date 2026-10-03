package com.mehmet.oyunmagazasi.mapper;

import org.mapstruct.Mapper;
import com.mehmet.oyunmagazasi.entity.*;
import com.mehmet.oyunmagazasi.dto.KullaniciRequestDto;

@Mapper(componentModel ="spring")
public interface KullaniciMapper {

    Kullanici toEntity(KullaniciRequestDto dto);
}
