package com.mehmet.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.blog.Repository.PostRepository;
import com.mehmet.blog.entity.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repo;

    public Post ekle(Post p) {
        return repo.save(p);
    }

    public List<Post> listele() {
        return repo.findAll();
    }

    public Post bul(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void sil(Long id) {
        repo.deleteById(id);
    }

    public Post guncelle(Long id, Post yeni) {
        Post eski = bul(id);
        eski.setBaslik(yeni.getBaslik());
        eski.setIcerik(yeni.getIcerik());
        return repo.save(eski);
    }

}
