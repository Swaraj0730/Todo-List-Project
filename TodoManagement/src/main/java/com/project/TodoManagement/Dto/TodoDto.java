package com.project.TodoManagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TodoDto {

    private long id;
    private String title;
    private String description;
    private boolean complete;
}
