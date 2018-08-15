/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities.builders;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.utils.Builder;
import com.mkandel.checklists.utils.UserType;

import static com.mkandel.checklists.utils.RandomGenerator.randomBoolean;
import static com.mkandel.checklists.utils.RandomGenerator.randomEnum;
import static com.mkandel.checklists.utils.RandomGenerator.randomString;
import static com.mkandel.checklists.utils.RandomGenerator.randomUUIDString;

public class UserBuilder implements Builder<User> {

    private String id = randomUUIDString();
    private String username = randomString();
    private String password = randomString();
    private String fName = randomString();
    private String lName = randomString();
    private String email = randomString() + "@email.org";
    private UserType type = randomEnum(UserType.class);
    private Boolean active = randomBoolean();

    @Override
    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFname(fName);
        user.setLname(lName);
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
