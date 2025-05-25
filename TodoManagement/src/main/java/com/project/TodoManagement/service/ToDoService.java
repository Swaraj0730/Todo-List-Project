package com.project.TodoManagement.service;

import com.project.TodoManagement.Dto.TodoDto;

import java.util.List;

public interface ToDoService {

    TodoDto AddTodo( TodoDto todoDto);

    TodoDto GetTodo(long Id) ;

    List<TodoDto> GetAll() ;

    TodoDto UpdateTodo(TodoDto todoDto , long id) ;

    void DeleteTodo(long id) ;

    TodoDto completeTodo(long id);

    TodoDto incompleteTodo(long id);

}
