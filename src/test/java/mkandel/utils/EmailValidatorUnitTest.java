/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

import com.mkandel.checklists.utils.EmailValidator;
import mkandel.BaseUnitTest;
import org.junit.Test;

import static mkandel.utils.RandomGenerator.generateRandomString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        String email = generateRandomString() + "@" + generateRandomString(5) + "." + generateRandomString(3);
        printEmail(email);
        assertTrue(emailValidator.validateEmail(email));
        // @.co.uk
        email = generateRandomString() + "@" + generateRandomString(5)
                + "." + generateRandomString(2) + "." + generateRandomString(2);
        printEmail(email);
        assertTrue(emailValidator.validateEmail(email));
    }

    @Test
    public void validateEmail_badEmail_returnsFalse() {
        // no TLD
        String email = generateRandomString() + "@" +  generateRandomString(5);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no domain
        email = generateRandomString() + "@" +  generateRandomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no domain, differently
        email = generateRandomString() + "@." +  generateRandomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // ..
        email = generateRandomString() + "@" + generateRandomString(5) + ".." +  generateRandomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no @
        email = generateRandomString() +  generateRandomString(5) + "." + generateRandomString(2);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
    }
}