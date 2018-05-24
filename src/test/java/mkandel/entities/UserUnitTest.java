/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import mkandel.*;
import mkandel.utils.*;
import org.junit.*;

import java.util.*;

import static mkandel.utils.RandomDataGenerator.*;
import static mkandel.utils.UserType.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class UserUnitTest extends BaseUnitTest {

    private User user = new User();

    @Test
    public void getAndSetId() {
        UUID uuid = java.util.UUID.randomUUID();
        System.out.println("uuid: " + uuid);
        user.setId(uuid);
        assertThat(uuid, equalTo(user.getId()));
    }

    @Test
    public void getAndSetAndSetfName() {
        String fName = randomString();
        System.out.println("fName: " + fName);
        user.setfName(fName);
        assertThat(fName, equalTo(user.getfName()));
    }

    @Test
    public void getAndSetlName() {
        String lName = randomString();
        System.out.println("lName: " + lName);
        user.setlName(lName);
        assertThat(lName, equalTo(user.getlName()));
    }

    @Test
    public void getAndSetUsername() {
        String username = randomString();
        System.out.println("username: " + username);
        user.setUsername(username);
        assertThat(username, equalTo(user.getUsername()));
    }

    @Test
    public void getAndSetEmail() {
        String email = randomString();
        System.out.println("email: " + email);
        try {
            user.setEmail(email);
        } catch (InvalidEmailException ex){
            String expected = ErrorMessageConstants.INVALID_EMAIL;
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