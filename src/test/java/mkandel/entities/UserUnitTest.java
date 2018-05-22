/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import mkandel.BaseUnitTest;
import mkandel.utils.ErrorMessageEnums;
import mkandel.utils.InvalidEmailException;
import mkandel.utils.RandomString;
import org.junit.Test;

import java.util.UUID;

import static mkandel.utils.UserTypesEnum.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserUnitTest extends BaseUnitTest {

    private User user = new User();
    RandomString generator = new RandomString();

    @Test
    public void getAndSetId() {
        UUID uuid = java.util.UUID.randomUUID();
        System.out.println("uuid: " + uuid);
        user.setId(uuid);
        assertThat(uuid, equalTo(user.getId()));
    }

    @Test
    public void getAndSetAndSetfName() {
        String fName = generator.nextString();
        System.out.println("fName: " + fName);
        user.setfName(fName);
        assertThat(fName, equalTo(user.getfName()));
    }

    @Test
    public void getAndSetlName() {
        String lName = generator.nextString();
        System.out.println("lName: " + lName);
        user.setlName(lName);
        assertThat(lName, equalTo(user.getlName()));
    }

    @Test
    public void getAndSetUsername() {
        String username = generator.nextString();
        System.out.println("username: " + username);
        user.setUsername(username);
        assertThat(username, equalTo(user.getUsername()));
    }

    @Test
    public void getAndSetEmail() {
        String email = generator.nextString();
        System.out.println("email: " + email);
        try {
            user.setEmail(email);
        } catch (InvalidEmailException ex){
            String expected = ErrorMessageEnums.INVALID_EMAIL;
            assertThat(ex.getMessage(), is(equalTo(expected)));
        }
        email = "some.fake@email.com";
        try {
            user.setEmail(email);
        } catch (InvalidEmailException ex){

        }
        assertThat(email, equalTo(user.getEmail()));
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

    @Test
    public void save() throws Exception {
        user.save();
    }
}