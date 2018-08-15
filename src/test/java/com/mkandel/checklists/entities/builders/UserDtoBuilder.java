/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities.builders;

import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.utils.Builder;
import com.mkandel.checklists.utils.UserType;

import static com.mkandel.checklists.utils.RandomGenerator.randomBoolean;
import static com.mkandel.checklists.utils.RandomGenerator.randomEnum;
import static com.mkandel.checklists.utils.RandomGenerator.randomString;
import static com.mkandel.checklists.utils.RandomGenerator.randomUUIDString;

public class UserDtoBuilder implements Builder<UserDto> {

    private String id = randomUUIDString();
    private String username = randomString();
    private String password = randomString();
    private String fName = randomString();
    private String lName = randomString();
    private String email = randomString() + "@email.org";
    private UserType type = randomEnum(UserType.class);
    private Boolean active = randomBoolean();

    @Override
    public UserDto build() {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setFname(fName);
        userDto.setLname(lName);
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

    public UserDtoBuilder withFirstName(String fName) {
        this.fName = fName;
        return this;
    }

    public UserDtoBuilder withLastName(String lName) {
        this.lName = lName;
        return this;
    }

    public UserDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
