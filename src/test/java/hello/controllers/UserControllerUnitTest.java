/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.controllers;

import hello.entities.User;
import hello.utils.RandomString;
import org.junit.Test;

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
    public void testUserEndpoint() throws Exception {
        String username = "admin";
        User actual = userController.user(username);

        assertThat(username, equalTo(actual.getUsername()));
    }
}