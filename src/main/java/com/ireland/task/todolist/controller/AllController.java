package com.ireland.task.todolist.controller;

import com.ireland.task.todolist.dto.CreateDTO;
import com.ireland.task.todolist.dto.SelectionDTO;
import com.ireland.task.todolist.entity.Todo;
import com.ireland.task.todolist.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Controller
public class AllController {

    @Autowired
    public ITodoService todoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        List<Todo> todos = todoService.getTodo(getCurrentUserName());
        model.addAttribute("selection", new SelectionDTO());
        model.addAttribute("todos",todos);
        return "home.html";
    }

    @RequestMapping(value = "/login",  method = RequestMethod.GET)
    public String login(){
        return"auth/login";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("todoDTO",new CreateDTO());
        return "addTodo.html";
    }

    @RequestMapping(value ="/create", method = RequestMethod.POST)
    public String createPost(CreateDTO createdto, BindingResult result, Model model){
        if(result.hasErrors())
        {
            model.addAttribute("todoDTO",new CreateDTO());
            return "home.html";
        }
        Todo todo = new Todo(createdto.getName(),new Date(),new Date(),createdto.getDescription(),Boolean.FALSE,getCurrentUserName());
        todoService.create(todo);
        model.addAttribute("todoDTO",new CreateDTO());
        return "redirect:/";
    }

    @RequestMapping(value ="/update", method = RequestMethod.POST)
    public String update(@RequestParam("selected") List<Long> ids){
            for(Long id : ids){
                Todo stodo = todoService.findById(id);
                if(stodo.getName() != "" && stodo.getId() != null){
                    stodo.setComplete(Boolean.TRUE);
                    stodo.setLasupdate(new Date());
                    todoService.create(stodo);
                }
            }

        return "redirect:/";
    }

    @RequestMapping(value = "/delete",  method = RequestMethod.POST)
    public String delete(@RequestParam("selected") List<Long> ids, @ModelAttribute SelectionDTO selectiondto){
        for(Long id : ids){
            Todo stodo = todoService.findById(id);
            if(stodo.getName() != "" && stodo.getId() != null){
                todoService.delete(stodo.getId());
            }
        }
        return"redirect:/";
    }

    public String getCurrentUserName(){
        String currentUserName="";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return currentUserName;
    }
}

