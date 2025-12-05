package com.mehmet.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
