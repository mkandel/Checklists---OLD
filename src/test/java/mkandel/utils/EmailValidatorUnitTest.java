/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

import mkandel.*;
import org.junit.*;

import static mkandel.utils.RandomDataGenerator.*;
import static org.junit.Assert.*;

public class EmailValidatorUnitTest extends BaseUnitTest {
    Boolean debug = true;
    EmailValidator emailValidator = new EmailValidator();

    private void printEmail(String email){
        if (debug) {
            System.out.println("*** Email: '" + email + "' ***");
        }
    }

    @Test
    public void validateEmail_goodEmail_returnsTrue() {
        // @.com
        String email = randomString() + "@" + randomString(5) + "." + randomAlphabeticString(3);
        printEmail(email);
        assertTrue(emailValidator.validateEmail(email));
        // @.co.uk
        email = randomString() + "@" + randomString(5)
                + "." + randomAlphabeticString(2) + "." + randomAlphabeticString(2);
        printEmail(email);
        assertTrue(emailValidator.validateEmail(email));
    }

    @Test
    public void validateEmail_badEmails_returnsFalse() {
        // no TLD
        String email = randomString() + "@" +  randomString(5);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no domain
        email = randomString() + "@" +  randomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no domain, differently
        email = randomString() + "@." +  randomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // ..
        email = randomString() + "@" + randomString(5) + ".." +  randomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no @
        email = randomString() +  randomString(5) + "." + randomAlphabeticString(2);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
    }
}