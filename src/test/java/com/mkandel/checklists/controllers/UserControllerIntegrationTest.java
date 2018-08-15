/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.controllers;

import com.mkandel.checklists.BaseIntegrationTest;
import com.mkandel.checklists.inbound.controllers.UserController;
import com.mkandel.checklists.inbound.converters.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    UserController userController;

    UserConverter userConverter = new UserConverter();

//    @Test
//    public void user_validUser_returnsCorrectUser() throws Exception {
//        User user = userRepository.save(new UserBuilder().build());
//
//        Optional<User> optionalUser = userConverter.toUser(userController.user(user.getUsername()));
//        assertThat(optionalUser).isPresent();
//        assertThat(optionalUser.get()).isEqualToComparingFieldByField(user);
//
//        userRepository.deleteById(user.getId());
//    }

//    @Test
//    public void userEndpoint_validUser_returnsCorrectUser() throws Exception {
//        User user = userRepository.save(new UserBuilder().build());
//
//        HttpResponse response =
//
//        userRepository.deleteById(user.getId());
//    }
}