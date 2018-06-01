/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import java.util.*;
import mkandel.*;
import mkandel.entities.*;
import mkandel.outbound.*;
import mkandel.utils.*;
import org.junit.*;
import org.mockito.*;

import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserControllerUnitTest extends BaseUnitTest {

    @Mock
    DbAdapter dbAdapter;

    @InjectMocks
    private UserController userController = new UserController();
//    mkandel.utils.RandomGenerator generator = new mkandel.utils.RandomGenerator();

    @Test
    public void testUsersEndpoint() throws Exception {
        User user = new UserBuilder().build();
        List<User> users = new ArrayList<>();
        users.add(user);
        when(dbAdapter.getUsers()).thenReturn(users);
        List<User> actual = userController.users();
        assert actual.size() == users.size();
        users.add(user);
        actual = userController.users();
        assert actual.size() == users.size();
    }

    // I know this is not really a good test
    @Test
    public void testUserEndpoint() throws Exception {
        String username = "admin";
        User user = new UserBuilder().withUsername(username).build();

        when(dbAdapter.getUser(username)).thenReturn(user);

        User actual = userController.user(username);

        assertThat(username, equalTo(actual.getUsername()));
    }
}