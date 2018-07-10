/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import java.util.UUID;

public class ChecklistItem extends BaseEntity {
    private UUID parentChecklistId;
    private String itemText;
    private Boolean completed;


    public ChecklistItem() {
        this.completed = false;
    }

    public ChecklistItem(UUID parentChecklistId) {
        this.completed = false;
        this.parentChecklistId = parentChecklistId;
    }

    public ChecklistItem(UUID parentChecklistId, String itemText) {
        this.completed = false;
        this.parentChecklistId = parentChecklistId;
        this.itemText = itemText;
    }

    public UUID getParentChecklistId() {
        return parentChecklistId;
    }

    public void setParentChecklistId(UUID parentChecklistId) {
        this.parentChecklistId = parentChecklistId;
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
