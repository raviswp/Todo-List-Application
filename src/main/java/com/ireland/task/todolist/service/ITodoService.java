package com.ireland.task.todolist.service;

import com.ireland.task.todolist.entity.Todo;

import java.util.List;

public interface ITodoService {

    public void create(Todo todo);
    public List<Todo> getTodo(String username);
    public Todo gettodobyidandusername(Long id, String username);

    public void delete(Long id);

    Todo findById(Long id);
}
