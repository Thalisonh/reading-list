package br.com.todolist.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.websocket.OnError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.todolist.model.StatusTodo;
import br.com.todolist.model.TodoList;
import br.com.todolist.repository.TodoListRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private TodoListRepository todoListRepository;
    
    @GetMapping
    public String home(Model model) {
        List<TodoList> todolist = todoListRepository.findAll();
        model.addAttribute("todolist", todolist);
        return "home";        
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {
        List<TodoList> todolist = todoListRepository.findByStatus(StatusTodo.valueOf(status.toUpperCase()));
        model.addAttribute("todolist", todolist);
        return "home";        
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String OnError(){
        return "redirect:/home";
    }
}
