/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities;

import com.mkandel.checklists.BaseUnitTest;
import com.mkandel.checklists.utils.ErrorMessageConstants;
import com.mkandel.checklists.utils.InvalidEmailException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.Ignore;
import org.junit.Test;

import static com.mkandel.checklists.utils.RandomGenerator.randomString;
import static com.mkandel.checklists.utils.UserType.ADMIN;
import static com.mkandel.checklists.utils.UserType.CREATOR;
import static com.mkandel.checklists.utils.UserType.USER;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserUnitTest extends BaseUnitTest {

    private User user = new User();

    @Test
    public void getAndSetId() {
        String uuid = randomString();
        System.out.println("uuid: " + uuid);
        user.setId(uuid);
        assertThat(uuid, equalTo(user.getId()));
    }

    @Test
    public void getAndSetAndSetFname() {
        String Fname = randomString();
        System.out.println("Fname: " + Fname);
        user.setFname(Fname);
        assertThat(Fname, equalTo(user.getFname()));
    }

    @Test
    public void getAndSetLname() {
        String Lname = randomString();
        System.out.println("Lname: " + Lname);
        user.setLname(Lname);
        assertThat(Lname, equalTo(user.getLname()));
    }

    @Test
    public void getAndSetUsername() {
        String username = randomString();
        System.out.println("username: " + username);
        user.setUsername(username);
        assertThat(username, equalTo(user.getUsername()));
    }

    @Ignore
    @Test
    public void getAndSetEmail() {
        StringProperty email = new SimpleStringProperty();
        email.set(randomString());
        System.out.println("email: " + email);
        assertThatExceptionOfType(InvalidEmailException.class)
                .isThrownBy(() -> user.setEmail(email.getValue()))
                .withMessageMatching(ErrorMessageConstants.INVALID_EMAIL);
        email.set("some.fake@email.com");
        assertThatCode(() -> user.setEmail(email.getValue()))
                .doesNotThrowAnyException();
        assertThat(email.getValue(), equalTo(user.getEmail()));
    }

    @Test
    public void getAndSetType() {
        user.setType(ADMIN);
        assertThat(ADMIN, equalTo(user.getType()));
        user.setType(USER);
        assertThat(USER, equalTo(user.getType()));
        user.setType(CREATOR);
        assertThat(CREATOR, equalTo(user.getType()));
    }

//    @Test
//    public void save() throws Exception {
//        user.save();
//    }
}