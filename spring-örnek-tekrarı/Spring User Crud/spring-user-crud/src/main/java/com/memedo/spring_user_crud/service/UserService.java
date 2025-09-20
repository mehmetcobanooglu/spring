package com.memedo.spring_user_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.memedo.spring_user_crud.model.User;
import com.memedo.spring_user_crud.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Tüm kullanıcıları listele
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Yeni kullanıcı ekle
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Kullanıcıyı Güncelle
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    // Kullanıcıyı Sil
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
