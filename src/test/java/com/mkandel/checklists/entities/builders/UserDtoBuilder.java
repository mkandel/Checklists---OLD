/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.entities.builders;

import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.utils.Builder;
import com.mkandel.checklists.utils.UserType;

import static com.mkandel.checklists.utils.RandomGenerator.*;

public class UserDtoBuilder implements Builder<UserDto> {

    private String id = randomUUIDString();
    private String username = randomString();
    private String password = randomString();
    private String fname = randomString();
    private String lname = randomString();
    private String email = randomString() + "@email.org";
    private UserType type = randomEnum(UserType.class);
    private Boolean active = randomBoolean();

    @Override
    public UserDto build() {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setFname(fname);
        userDto.setLname(lname);
        userDto.setEmail(email);
        userDto.setActive(active);
        userDto.setType(type);

        return userDto;
    }

    public UserDtoBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public UserDtoBuilder withid() {
        return this.withId(randomString());
    }

    public UserDtoBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDtoBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDtoBuilder withFirstName(String fname) {
        this.fname = fname;
        return this;
    }

    public UserDtoBuilder withLastName(String lname) {
        this.lname = lname;
        return this;
    }

    public UserDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
