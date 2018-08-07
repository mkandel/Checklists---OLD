/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

public class Routes {
    public static final String BASE = "/api";
    public static final String BASEV1 = "/v1";
    public static final String HEALTH = BASE + "/health";
    public static final String VALIDADTE_EMAIL = BASE + "/validateEmail/{email}";

    public static final String USERS = BASE + "/users";
    public static final String USERNAMES = BASE + "/usernames";
    public static final String USER = BASE + "/user/{username}";
    public static final String USER_TYPES = USERS + "/types";

    public static final String ADD_USER = BASE + "/user/{username}/{Fname}/{Lname}/{email}/{type}";

    // Dummy route to play around with
    public static final String TEAPOT = BASE + "/teapot";

}
