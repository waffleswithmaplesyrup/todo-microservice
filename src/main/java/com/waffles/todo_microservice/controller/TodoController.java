package com.waffles.todo_microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping
    public String helloWorld() {
        return "Hello world from todo microservice";
    }
}
