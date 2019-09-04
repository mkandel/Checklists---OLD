/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

public class Routes {
<<<<<<< HEAD:src/main/java/mkandel/utils/Routes.java
    public static final String BASE = "/api";
    public static final String BASEV1 = BASE + "v1";
=======
    public static final String BASE = "";
    //public static final String BASE = "/api";
    //public static final String BASEV1 = BASE + "/v1";
>>>>>>> 41ee048da52edc879c79f335ef992a686bbd1f1e:src/main/java/com/mkandel/checklists/utils/Routes.java
    public static final String HEALTH = BASE + "/health";
    public static final String VALIDATE_EMAIL = BASE + "/validateEmail/{email}";

    public static final String USERS = BASE + "/users";
<<<<<<< HEAD:src/main/java/mkandel/utils/Routes.java
    public static final String USER = BASE + "/user/{id}";
    public static final String USER_BY_USERNAME = BASE + "/userByUsername/{username}";
    public static final String USER_TYPES = USERS + "/types";

    public static final String ADD_USER = BASE + "/userByUsername/{username}/{fName}/{lName}/{email}/{type}";

    // Dummy route to play around with
    public static final String TEAPOT = BASE + "/teapot";
}
=======
    public static final String USERNAMES = BASE + "/usernames";
    public static final String USER = USERS + "/{username}";
    public static final String USER_TYPES = USERS + "/types";

    // Dummy route to play around with
    public static final String TEAPOT = BASE + "/teapot";

}
>>>>>>> 41ee048da52edc879c79f335ef992a686bbd1f1e:src/main/java/com/mkandel/checklists/utils/Routes.java
