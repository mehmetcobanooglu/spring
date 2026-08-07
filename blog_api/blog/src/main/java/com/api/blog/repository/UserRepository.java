package com.api.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
