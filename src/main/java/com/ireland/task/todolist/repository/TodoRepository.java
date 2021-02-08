package com.ireland.task.todolist.repository;

import com.ireland.task.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    List < Todo > findByUsername(String user);

    Todo findByIdAndUsername(Long id, String user);

    void deleteByIdAndComplete(Long id, Boolean value);
}
