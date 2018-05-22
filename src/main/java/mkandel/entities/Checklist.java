/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

public class Checklist {
    private UUID id;
    private UUID createUserId;
    private UUID updateUserId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String title;
    private Collection<ChecklistItem> checklistItems;
}
