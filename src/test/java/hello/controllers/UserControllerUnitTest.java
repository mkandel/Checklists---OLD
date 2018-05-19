/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.controllers;

import hello.entities.User;
import hello.utils.RandomString;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class UserControllerUnitTest {

    private UserController userController = new UserController();
    RandomString generator = new RandomString();

    @Test
    public void testUsersEndpoint() {
        User[] actual = userController.users();
        // Assert that the stub returns an empty array
        assertArrayEquals(new User[0], actual);
    }

    @Test
    public void testUserEndpoint() {
        UUID id = java.util.UUID.randomUUID();
        User actual = userController.user(id);
        // Assert that the stub returns the right userId
        assertThat(id, equalTo(actual.getId()));
    }
}