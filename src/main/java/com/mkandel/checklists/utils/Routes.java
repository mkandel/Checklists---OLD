/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.utils;

public class Routes {
    public static final String ROOT = "/api";
    public static final String BASE = ROOT + "/v1";

    public static final String HEALTH = BASE + "/health";
    public static final String VALIDATE_EMAIL = BASE + "/validateEmail/{email}";

    public static final String USERS = BASE + "/users";
    public static final String USER = BASE + "/user/{id}";
    public static final String USER_BY_USERNAME = BASE + "/userByUsername/{username}";

    // Testing
    public static final String USERNAMES = BASE + "/usernames";

    public static final String USER_TYPES = USERS + "/types";

    public static final String ADD_USER = BASE + "/userByUsername/{username}/{fName}/{lName}/{email}/{type}";

    // Dummy route to play around with
    public static final String TEAPOT = BASE + "/teapot";
}

