package com.ireland.task.todolist.service;

import com.ireland.task.todolist.entity.Todo;
import com.ireland.task.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;

    public TodoService() {
    }

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void create(Todo todo){
        todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodo(String username) {
        List<Todo> todos = todoRepository.findByUsername(username);
        return todos;
    }

    @Override
    public Todo gettodobyidandusername(Long id, String username) {
      Todo todo =  todoRepository.findByIdAndUsername(id,username);
        return todo;
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent())
            return todo.get();
        return new Todo();
    }

}
