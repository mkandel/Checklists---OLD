/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel.entities;

import java.util.UUID;

public class Checklist extends BaseEntity  {
    private UUID template;
    private UUID ownerUserId;
    private String title;
//    private Collection<ChecklistItem> checklistItems;
}
