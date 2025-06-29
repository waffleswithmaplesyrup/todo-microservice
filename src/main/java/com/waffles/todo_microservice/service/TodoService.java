package com.waffles.todo_microservice.service;

import com.waffles.todo_microservice.model.Todo;
import com.waffles.todo_microservice.repository.StatusRepository;
import com.waffles.todo_microservice.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TodoService {

    private final TodoRepository todoRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, StatusRepository statusRepository) {
        this.todoRepository = todoRepository;
        this.statusRepository = statusRepository;
    }

    public List<Todo> viewAllTodos() {

        System.out.println(statusRepository.findAll().toString());
//        System.out.println(todoRepository.findAll().toString());

        return todoRepository.findAll();
    }
}
