package com.ireland.task.todolist.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date creationdate;
    private Date lasupdate;
    private String description;
    private Boolean complete;
    private String username;

    public Todo() {
    }

    public Todo(String name, Date creationdate, Date lasupdate, String description, Boolean complete, String userName) {
        this.name = name;
        this.creationdate = creationdate;
        this.lasupdate = lasupdate;
        this.description = description;
        this.complete = complete;
        this.username = userName;
    }

    public Todo(Long id, String name, Date creationdate, Date lasupdate, String description, Boolean complete, String userName) {
        this.id = id;
        this.name = name;
        this.creationdate = creationdate;
        this.lasupdate = lasupdate;
        this.description = description;
        this.complete = complete;
        username = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getLasupdate() {
        return lasupdate;
    }

    public void setLasupdate(Date lasupdate) {
        this.lasupdate = lasupdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
