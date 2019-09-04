/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.outbound.repositories;

import com.mkandel.checklists.BaseIntegrationTest;
import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.entities.builders.UserBuilder;
import java.util.Optional;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryIntegrationTest extends BaseIntegrationTest {

    @Autowired
    UserRepository userRepository;

    private User user = new UserBuilder().build();

    @Ignore
    @Test
    public void save_user_userSaves() {
        user = userRepository.save(new UserBuilder().build());
        assertThat(user).isNotNull();
        userRepository.deleteById(user.getId());
    }

    @Ignore
    @Test
    public void deleteById_user_userDeletes() {
        user = userRepository.save(new UserBuilder().build());
        userRepository.deleteById(user.getId());
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        assertThat(optionalUser).isNotPresent();
    }
}
