package com.ireland.task.todolist.dto;

import java.util.Date;

public class CreateDTO {
    private String name;
    private String description;

    public CreateDTO() {
    }

    public CreateDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
