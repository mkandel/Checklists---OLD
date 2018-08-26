/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

public enum UserType {
    ADMIN(0, "Admin"),
    CREATOR(1, "Creator"),
    USER(2, "User");

    private final double id;
    private final String text;

    UserType(double id, String text) {
        this.id = id;
        this.text = text;
    }

    public double getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
