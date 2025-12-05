package com.mehmet.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.mehmet.todo.entity.Todo;
import com.mehmet.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService b;

    @PostMapping
    public Todo ekle(@RequestBody Todo t) {
        System.out.println("Gelen Todo = " + t);
        return b.ekle(t);
    }

    @GetMapping
    public List<Todo> listele() {
        return b.listele();
    }

    @DeleteMapping("/delete/{id}")
    public void sil(@PathVariable Long id) {
        b.sil(id);
    }

    @PutMapping("/{id}")
    public Todo kontrol(@PathVariable Long id) {
        return b.tamamlandi(id);
    }
}