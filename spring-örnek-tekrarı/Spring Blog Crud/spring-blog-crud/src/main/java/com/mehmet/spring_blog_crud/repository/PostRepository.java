package com.mehmet.spring_blog_crud.repository;

import com.mehmet.spring_blog_crud.model.Post;
import com.mehmet.spring_blog_crud.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}