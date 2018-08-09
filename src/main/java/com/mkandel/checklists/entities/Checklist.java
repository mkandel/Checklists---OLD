/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Table(name = "Checklists")
public class Checklist {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
    private UUID id;
    private UUID createUserId;
    private UUID updateUserId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String title;
    private Collection<ChecklistItem> checklistItems;
}
