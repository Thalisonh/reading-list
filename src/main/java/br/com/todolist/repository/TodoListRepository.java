package br.com.todolist.repository;

import org.springframework.stereotype.Repository;

import br.com.todolist.model.StatusTodo;
import br.com.todolist.model.TodoList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long>{

    List<TodoList> findByStatus(StatusTodo status);
    
}
