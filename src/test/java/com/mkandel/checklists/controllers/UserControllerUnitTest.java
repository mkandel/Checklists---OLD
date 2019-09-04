/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.controllers;

import com.mkandel.checklists.BaseUnitTest;
import org.junit.Test;

public class UserControllerUnitTest extends BaseUnitTest {

    @Test
    public void trueTest() {
        assert true;
    }
    //    @Mock
    //    UserRepository userRepository;
    //
    //    @InjectMocks
    //    private UserController userController = new UserController();
    //
    //    @Test
    //    public void testUsersEndpoint() {
    //        User user = new UserBuilder().build();
    //        List<User> users = new ArrayList<>();
    //        users.add(user);
    //        when(userRepository.findAll()).thenReturn(users);
    //        List<UserDto> actual = userController.users();
    //        assert actual.size() == users.size();
    //        users.add(user);
    //        actual = userController.users();
    //        assert actual.size() == users.size();
    //    }
    //
    //    // I know this is not really a good test
    //    @Test
    //    public void testUserEndpoint() throws Exception {
    //        String username = "admin";
    //        UserDto userDto = new UserDtoBuilder().withUsername(username).build();
    //        User user = new UserBuilder().withUsername(username).build();
    //
    //        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
    //
    //        UserDto actual = userController.user(username);
    //
    //        assertThat(username, equalTo(actual.getUsername()));
    //    }
}
