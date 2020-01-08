/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel.entities;

import java.util.Collection;
import java.util.UUID;

public class ChecklistTemplate extends BaseEntity  {
    private UUID ownerUserId;
    private String title;
    private Collection<ChecklistItem> checklistItems;
}
