/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import mkandel.BaseUnitTest;
import mkandel.entities.User;
import mkandel.utils.RandomString;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UserControllerUnitTest extends BaseUnitTest {

    private UserController userController = new UserController();
    RandomString generator = new RandomString();

    @Test
    public void testUsersEndpoint() throws Exception {
        List<User> actual = userController.users();
        assert actual.size() == 2;
    }

    // I know this is not really a good test
    @Test
    public void testUserEndpoint() throws Exception {
        String username = "admin";
        User actual = userController.user(username);

        assertThat(username, equalTo(actual.getUsername()));
    }
}