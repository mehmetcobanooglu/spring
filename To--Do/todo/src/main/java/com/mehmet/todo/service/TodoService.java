package com.mehmet.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.todo.entity.Todo;
import com.mehmet.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository a;

    public Todo ekle(Todo t) {

        if (t.getTamamlandi() == null) {
            t.setTamamlandi(false);
        }

        return a.save(t);
    }

    public Todo tamamlandi(Long id) {
        Todo t = a.findById(id).orElseThrow();
        t.setTamamlandi(true);
        return a.save(t);
    }

    public void sil(Long id) {
        a.deleteById(id);
    }

    public List<Todo> listele() {
        return a.findAll();
    }
}
