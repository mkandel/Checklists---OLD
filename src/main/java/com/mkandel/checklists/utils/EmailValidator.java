/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

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
    private final static Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public EmailValidator() {
        // initialize the Pattern object
        //pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public boolean validateEmail(String email) {
        // non-static Matcher object because it's created from the input String
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
