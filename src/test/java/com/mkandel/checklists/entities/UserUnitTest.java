/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities;

import com.mkandel.checklists.BaseUnitTest;
import com.mkandel.checklists.entities.builders.UserBuilder;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

import static com.mkandel.checklists.utils.RandomGenerator.randomInteger;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class UserUnitTest extends BaseUnitTest {

    int size = randomInteger(5, 10);
    List<User> users = Stream
            .generate(() ->
                    new UserBuilder()
                            .withid()
                            .build())
            .limit(size)
            .collect(toList());

    @Test
    public void testOne() {
        assertThat(users).isNotNull();
        assertThat(users).hasSize(size);
    }
}