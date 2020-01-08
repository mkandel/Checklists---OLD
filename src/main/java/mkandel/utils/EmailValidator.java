/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java email validation program
 * Swiped from https://www.journaldev.com/638/java-email-validation-regex
 *
 * @author pankaj
 *
 */
public class EmailValidator {
    // Email Regex java
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // static Pattern object, since pattern is fixed
    private static Pattern pattern;

    public EmailValidator() {
        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    /**
     * This method validates the input email address with EMAIL_REGEX pattern
     *
     * @param email
     * @return boolean
     */
    public boolean validateEmail(String email) {
        // non-static Matcher object because it's created from the input String
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
