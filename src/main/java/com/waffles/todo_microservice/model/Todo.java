package com.waffles.todo_microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private OffsetDateTime dtCreated;
    private OffsetDateTime dtUpdated;
    @ManyToOne
    private Status status;

    public Todo(String title, String content, Status status) {
        this.title = title;
        this.content = content;
        this.dtCreated = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.status = status;
    }
}
