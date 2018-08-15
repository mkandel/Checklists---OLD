/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.dtos;

import com.mkandel.checklists.utils.UserType;
import org.springframework.http.MediaType;

public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private boolean active;
    private UserType type;

    public final static String JSON_MIME_TYPE = "application/json;type=checklists-user;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType( JSON_MIME_TYPE );

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
