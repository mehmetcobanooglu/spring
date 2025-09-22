package com.mehmet.spring_blog_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.spring_blog_crud.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
