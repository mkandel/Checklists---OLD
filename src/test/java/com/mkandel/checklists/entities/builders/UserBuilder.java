/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.entities.builders;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.utils.Builder;
import com.mkandel.checklists.utils.UserType;

import static com.mkandel.checklists.utils.RandomGenerator.*;

public class UserBuilder implements Builder<User> {

    private String id = randomUUIDString();
    private String username = randomString();
    private String password = randomString();
    private String fname = randomString();
    private String lname = randomString();
    private String email = randomEmail();
    private UserType type = randomEnum(UserType.class);
    private Boolean active = randomBoolean();

    @Override
    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFname(fname);
        user.setLname(lname);
        user.setEmail(email);
        user.setActive(active);
        user.setType(type);

        return user;
    }

    public UserBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder withid() {
        return this.withId(randomString());
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withFirstName(String fname) {
        this.fname = fname;
        return this;
    }

    public UserBuilder withLastName(String lname) {
        this.lname = lname;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
