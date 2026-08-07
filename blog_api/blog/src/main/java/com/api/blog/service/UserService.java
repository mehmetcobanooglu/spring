package com.api.blog.service;

import org.springframework.stereotype.Service;

import com.api.blog.dto.UserCreateRequestDto;
import com.api.blog.dto.UserResponseDto;
import com.api.blog.entity.User;
import com.api.blog.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto saveUser(UserCreateRequestDto dto) {

        // DTO - ENTİTY ÇEVİRME

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        // database kayit

        User db = userRepository.save(user);

        // Entity-Response DTO Çevirme

        UserResponseDto responseDto = new UserResponseDto(
                db.getId(), db.getName(), db.getEmail()

        );

        return responseDto;
    }
}
