/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

//@Entity
public class Checklist {
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", unique = true)
    private UUID id;
    private UUID createUserId;
    private UUID updateUserId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String title;
    private Collection<ChecklistItem> checklistItems;
}
