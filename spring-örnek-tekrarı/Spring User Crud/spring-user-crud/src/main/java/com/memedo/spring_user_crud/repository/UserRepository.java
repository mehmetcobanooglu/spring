package com.memedo.spring_user_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memedo.spring_user_crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
