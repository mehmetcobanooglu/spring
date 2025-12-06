package com.mehmet.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmet.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
