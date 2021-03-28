package br.com.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.todolist.dto.RequisicaoNovaTarefa;
import br.com.todolist.model.TodoList;
import br.com.todolist.repository.TodoListRepository;

@Controller
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoListRepository todoRepository;
    
    @GetMapping("formulario")
    public String formulario(){
        return "todo/formulario";
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovaTarefa requisicao, BindingResult result) {
        if(result.hasErrors()){
            return "todo/formulario";
        }

        TodoList todo = requisicao.toTodo();
        todoRepository.save(todo);

        return "redirect:/home";
    }
}
