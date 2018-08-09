/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.utils.ErrorMessageConstants;
import com.mkandel.checklists.utils.InvalidEmailException;
import java.util.UUID;
import mkandel.BaseUnitTest;
import org.junit.Test;

import static com.mkandel.checklists.utils.UserType.ADMIN;
import static com.mkandel.checklists.utils.UserType.CREATOR;
import static com.mkandel.checklists.utils.UserType.USER;
import static mkandel.utils.RandomGenerator.generateRandomString;
import static mkandel.utils.RandomGenerator.generateRandomUUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserUnitTest extends BaseUnitTest {

    private User user = new User();

    @Test
    public void getAndSetId() {
        UUID uuid = generateRandomUUID();
        System.out.println("uuid: " + uuid);
        user.setId(uuid);
        assertThat(uuid, equalTo(user.getId()));
    }

    @Test
    public void getAndSetAndSetFname() {
        String Fname = generateRandomString();
        System.out.println("Fname: " + Fname);
        user.setFname(Fname);
        assertThat(Fname, equalTo(user.getFname()));
    }

    @Test
    public void getAndSetLname() {
        String Lname = generateRandomString();
        System.out.println("Lname: " + Lname);
        user.setLname(Lname);
        assertThat(Lname, equalTo(user.getLname()));
    }

    @Test
    public void getAndSetUsername() {
        String username = generateRandomString();
        System.out.println("username: " + username);
        user.setUsername(username);
        assertThat(username, equalTo(user.getUsername()));
    }

    @Test
    public void getAndSetEmail() {
        String email = generateRandomString();
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

//    @Test
//    public void save() throws Exception {
//        user.save();
//    }
}