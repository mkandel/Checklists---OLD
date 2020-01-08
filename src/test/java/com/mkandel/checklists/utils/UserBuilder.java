/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.utils;

import com.mkandel.checklists.entities.User;

import java.util.UUID;

//import static mkandel.utils.RandomGenerator.*;

public class UserBuilder implements Builder {

    private String id;
    private String username;
    private String fName;
    private String lName;
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
        this.id = UUID.randomUUID().toString();
        return this;
    }

    public UserBuilder withUsername(String username){
        this.username = username;
        return this;
    }
}
