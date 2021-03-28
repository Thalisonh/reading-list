package br.com.todolist.dto;

import br.com.todolist.model.StatusTodo;
import br.com.todolist.model.TodoList;

public class RequisicaoNovaTarefa {
    private String titulo;
    private String autor;
    private String urlImagem;
    private String descricao;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TodoList toTodo(){
        TodoList todo = new TodoList();
        todo.setNome(titulo);
        todo.setAutor(autor);
        todo.setUrlImagem(urlImagem);
        todo.setDescricao(descricao);
        todo.setStatus(StatusTodo.QUEROLER);

        return todo;
    }
}
