package hello;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserUnitTest {

    private User user = new User();
    RandomString generator = new RandomString();

    @Test
    public void getAndSetId() {
        String id = generator.nextString();
        System.out.println("id: " + id);
        user.setId(id);
        assertThat(id, equalTo(user.getId()));
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
    public void getAndSetAlias() {
        String alias = generator.nextString();
        System.out.println("alias: " + alias);
        user.setAlias(alias);
        assertThat(alias, equalTo(user.getAlias()));
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
}