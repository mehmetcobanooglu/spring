package com.mehmet.spring_blog_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mehmet.spring_blog_crud.model.Post;
import com.mehmet.spring_blog_crud.model.User;
import com.mehmet.spring_blog_crud.service.PostService;
import com.mehmet.spring_blog_crud.service.UserService;

@Controller
public class BlogController {

    private final UserService userService;
    private final PostService postService;

    public BlogController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    // Ana Sayfa - Tüm Postlar
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index"; // index.html
    }

    // Yeni Post Ekleme Sayfası
    @GetMapping("/posts/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "new-post"; // new-post.html
    }

    @PostMapping("/posts")
    public String savePost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    // Yeni User Ekleme Sayfası
    @GetMapping("/users/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
