package com.project.TodoManagement.controller;

import com.project.TodoManagement.Dto.TodoDto;
import com.project.TodoManagement.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todolist")
@AllArgsConstructor
public class TodoController {

    private ToDoService toDoService ;

    //BUILD ADD TODO REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodoDto = toDoService.AddTodo(todoDto);
        return new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> GetTodo(@PathVariable long id){
        TodoDto todoDto = toDoService.GetTodo(id);
        return new ResponseEntity<>(todoDto,HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<TodoDto>> GetAll() {
        List<TodoDto> list = toDoService.GetAll();
        //return new ResponseEntity<>(list,HttpStatus.OK);
        return ResponseEntity.ok(list) ;
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo ( @RequestBody TodoDto todoDto ,
                                                @PathVariable("id") long todoId ){
        TodoDto updatedTodo = toDoService.UpdateTodo(todoDto , todoId );
        return ResponseEntity.ok(updatedTodo) ;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteTodo (@PathVariable long id){
        toDoService.DeleteTodo(id);
        return ResponseEntity.ok("deleted Successfully");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> CompleteTodo(@PathVariable long id) {
        TodoDto todoDto = toDoService.completeTodo(id);
        return ResponseEntity.ok(todoDto) ;
    }


    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> IncompleteTodo(@PathVariable long id) {
        TodoDto todoDto = toDoService.incompleteTodo(id);
        return ResponseEntity.ok(todoDto) ;
    }


}
