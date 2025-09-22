package com.mehmet.spring_blog_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.spring_blog_crud.model.Post;
import com.mehmet.spring_blog_crud.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
