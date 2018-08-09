/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import com.mkandel.checklists.controllers.UserController;
import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.outbound.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import mkandel.BaseUnitTest;
import mkandel.utils.UserBuilder;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class UserControllerUnitTest extends BaseUnitTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserController userController = new UserController();
//    mkandel.utils.RandomGenerator generator = new mkandel.utils.RandomGenerator();

    @Test
    public void testUsersEndpoint() throws Exception {
        User user = new UserBuilder().build();
        List<User> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);
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

        when(userRepository.findByUsername(username)).thenReturn(user);

        User actual = userController.user(username);

        assertThat(username, equalTo(actual.getUsername()));
    }
}