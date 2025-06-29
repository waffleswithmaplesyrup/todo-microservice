package com.waffles.todo_microservice.controller;

import com.waffles.todo_microservice.model.Todo;
import com.waffles.todo_microservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String helloWorld() {
        return "Hello world from todo microservice";
    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllTodos() {
        try {
            return ResponseEntity.ok(
                    todoService.viewAllTodos()
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
