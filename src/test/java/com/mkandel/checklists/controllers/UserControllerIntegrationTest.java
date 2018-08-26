/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.controllers;

import com.mkandel.checklists.BaseIntegrationTest;
import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.entities.builders.UserBuilder;
import com.mkandel.checklists.inbound.controllers.UserController;
import com.mkandel.checklists.inbound.dtos.UserDto;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.mkandel.checklists.inbound.converters.UserConverter.toUserDto;

public class UserControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    UserController userController;

    @Ignore
    @Test
    public void user_validUser_returnsCorrectUser() throws Exception {
        UserDto expected = toUserDto(userRepository.save(new UserBuilder().build()));

        userRepository.deleteById(expected.getId());
    }

    @Ignore
    @Test
    public void userEndpoint_validUser_returnsCorrectUser() throws Exception {
        User user = userRepository.save(new UserBuilder().build());

        userRepository.deleteById(user.getId());
    }
}