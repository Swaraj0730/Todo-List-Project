package com.project.TodoManagement.repository;

import com.project.TodoManagement.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
