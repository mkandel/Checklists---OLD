/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.entities;

import java.util.UUID;

public class ChecklistItem {
    private UUID id;
    private UUID parentId;
    private String itemText;
    private Boolean completed;


    public ChecklistItem() {
        this.completed = false;
    }

    public ChecklistItem(UUID parentId) {
        this.completed = false;
        this.parentId = parentId;
    }

    public ChecklistItem(UUID parentId, String itemText) {
        this.completed = false;
        this.parentId = parentId;
        this.itemText = itemText;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
