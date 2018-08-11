/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

import com.mkandel.checklists.entities.User;

import static com.mkandel.checklists.utils.RandomGenerator.generateRandomString;

public class UserBuilder implements Builder {

    private String id;
    private String username;
    private String Fname;
    private String Lname;
    private String email;
    private UserType type;
    private Boolean active;

    @Override
    public User build() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);

        return user;
    }

    public UserBuilder withId(String id){
        this.id = id;
        return this;
    }

    public UserBuilder withiRandomId(){
        this.id = generateRandomString();
        return this;
    }

    public UserBuilder withUsername(String username){
        this.username = username;
        return this;
    }
}
