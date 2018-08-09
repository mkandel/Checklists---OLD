/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Table(name = "ChecklistTemplates")
public class ChecklistTemplate {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
    private UUID id;
    private UUID createUserId;
    private UUID updateUserId;
    private LocalDate createTime;
    private LocalDate updateTime;
    private String title;
    private Collection<ChecklistItem> checklistItems;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(UUID createUserId) {
        this.createUserId = createUserId;
    }

    public UUID getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(UUID updateUserId) {
        this.updateUserId = updateUserId;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<ChecklistItem> getChecklistItems() {
        return checklistItems;
    }

    public void setChecklistItems(Collection<ChecklistItem> checklistItems) {
        this.checklistItems = checklistItems;
    }
}
