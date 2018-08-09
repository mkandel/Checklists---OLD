/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities;

import com.mkandel.checklists.utils.Builder;
import com.mkandel.checklists.utils.UserType;

import static com.mkandel.checklists.utils.RandomGenerator.generateRandomString;
import static com.mkandel.checklists.utils.UserType.USER;

public class UserBuilder implements Builder<User> {


    private String username = generateRandomString();
    private String password = generateRandomString();
    private String fName = generateRandomString();
    private String lName = generateRandomString();
    private String email = generateRandomString();
    private UserType type = USER;
    private Boolean active = true;

    @Override
    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setType(type);

        return user;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withFirstName(String fName) {
        this.fName = fName;
        return this;
    }

    public UserBuilder withLastName(String lName) {
        this.lName = lName;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
