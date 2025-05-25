package com.project.TodoManagement.service.impl;

import com.project.TodoManagement.Dto.TodoDto;
import com.project.TodoManagement.Exception.ResourceNotFoundException;
import com.project.TodoManagement.entity.Todo;
import com.project.TodoManagement.repository.TodoRepository;
import com.project.TodoManagement.service.ToDoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class TodoServiceImpl implements ToDoService {

    private TodoRepository todoRepository ;
    private ModelMapper modelMapper ;

    @Override
    public TodoDto AddTodo(TodoDto todoDto) {

        //convert todo dto into jpa entity
        Todo todo = modelMapper.map(todoDto,Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        //convert saved todo jap entity into todo dto
        TodoDto savedtodoDto = modelMapper.map(savedTodo,TodoDto.class);

        return savedtodoDto;
    }

    @Override
    public TodoDto GetTodo(long Id) {

        Todo todo = todoRepository.findById(Id).orElseThrow(
                ()-> new ResourceNotFoundException(" Todo not found with id" + Id)
        );
        return modelMapper.map(todo,TodoDto.class);
    }

    @Override
    public List<TodoDto> GetAll() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo)-> modelMapper.map(todo,TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto UpdateTodo(TodoDto todoDto, long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id " + id)
        );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setComplete(todoDto.isComplete());

        Todo upateTodo = todoRepository.save(todo);
        return modelMapper.map(upateTodo, TodoDto.class);
    }

    @Override
    public void DeleteTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo does not exist with id" + id)
        );
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo does not exist with id" + id)
        );
        todo.setComplete(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(todo,TodoDto.class) ;
    }

    @Override
    public TodoDto incompleteTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo does not exist with id" + id)
        );
        todo.setComplete(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(todo,TodoDto.class) ;
    }
}
