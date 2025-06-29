package com.waffles.todo_microservice;

import com.waffles.todo_microservice.model.Status;
import com.waffles.todo_microservice.model.Todo;
import com.waffles.todo_microservice.repository.StatusRepository;
import com.waffles.todo_microservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoDatabaseLoader implements ApplicationRunner {

    private final TodoRepository todoRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public TodoDatabaseLoader(TodoRepository todoRepository, StatusRepository statusRepository) {
        this.todoRepository = todoRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Status> statusList = statusRepository.saveAll(List.of(
                new Status("Unassigned"),
                new Status("In Progress"),
                new Status("Completed")
        ));

        todoRepository.saveAll(List.of(
                new Todo("Fix bug", "<p>Bugs need fixing</p>", statusList.get(1)),
                new Todo("Feed cat medicine", "<p>Cat needs steroids for asthma.</p><p>Side effects: cat may become buff.</p>", statusList.get(2)),
                new Todo("Groceries", "<p>To buy:</p><ul><li>bananas</li><li>liquid detergent</li><li>eggs</li></ul>", statusList.get(0))
        ));
    }
}
