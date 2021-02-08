package com.ireland.task.todolist.dto;

import java.util.ArrayList;
import java.util.List;

public class SelectionDTO {

    private List<Long> selected = new ArrayList<>();

    public SelectionDTO() {
    }

    public SelectionDTO(List<Long> selected) {
        this.selected = selected;
    }

    public List<Long> getSelected() {
        return selected;
    }

    public void setSelected(List<Long> selected) {
        this.selected = selected;
    }
}
