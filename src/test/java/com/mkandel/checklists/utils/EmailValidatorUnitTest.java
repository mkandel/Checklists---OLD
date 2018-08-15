/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

import com.mkandel.checklists.BaseUnitTest;
import org.junit.Test;

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
        String email = RandomGenerator.randomString() + "@" + RandomGenerator.randomString(5) + "." + RandomGenerator.randomString(3);
        printEmail(email);
        assertTrue(emailValidator.validateEmail(email));
        // @.co.uk
        email = RandomGenerator.randomString() + "@" + RandomGenerator.randomString(5)
                + "." + RandomGenerator.randomString(2) + "." + RandomGenerator.randomString(2);
        printEmail(email);
        assertTrue(emailValidator.validateEmail(email));
    }

    @Test
    public void validateEmail_badEmail_returnsFalse() {
        // no TLD
        String email = RandomGenerator.randomString() + "@" +  RandomGenerator.randomString(5);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no domain
        email = RandomGenerator.randomString() + "@" +  RandomGenerator.randomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no domain, differently
        email = RandomGenerator.randomString() + "@." +  RandomGenerator.randomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // ..
        email = RandomGenerator.randomString() + "@" + RandomGenerator.randomString(5) + ".." +  RandomGenerator.randomString(3);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
        // no @
        email = RandomGenerator.randomString() +  RandomGenerator.randomString(5) + "." + RandomGenerator.randomString(2);
        printEmail(email);
        assertFalse(emailValidator.validateEmail(email));
    }
}