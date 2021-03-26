package br.com.todolist.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.todolist.model.TodoList;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager entityManager;
    
    @GetMapping("/home")
    public String home(Model model) {

        Query query = entityManager.createQuery("select t from TodoList t", TodoList.class);
        List<TodoList> todolist = query.getResultList();

        for(int i = 0; i < todolist.size(); i++){
            System.out.println(todolist.get(i).getNome());;
        }
        
        model.addAttribute("todolist", todolist);

        return "home";
        
    }
}
