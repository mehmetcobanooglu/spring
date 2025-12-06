package com.mehmet.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.blog.entity.Post;
import com.mehmet.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping
    public Post ekle(@RequestBody Post p) {
        return service.ekle(p);
    }

    @GetMapping
    public List<Post> listele() {
        return service.listele();
    }

    @GetMapping("/{id}")
    public Post getir(@PathVariable Long id) {
        return service.bul(id);
    }

    @PutMapping("/{id}")
    public Post guncelle(@PathVariable Long id, @RequestBody Post p) {
        return service.guncelle(id, p);
    }

    @DeleteMapping("/{id}")
    public void sil(@PathVariable Long id) {

        service.sil(id);
    }
}
