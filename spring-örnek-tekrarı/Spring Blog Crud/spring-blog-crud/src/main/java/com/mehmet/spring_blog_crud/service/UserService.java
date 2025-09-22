package com.mehmet.spring_blog_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.spring_blog_crud.model.User;
import com.mehmet.spring_blog_crud.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
