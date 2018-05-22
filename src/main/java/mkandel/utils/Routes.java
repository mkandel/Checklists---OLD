/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

public class Routes {
    public static final String BASE = "/api/v1";

    public static final String USERS = BASE + "/users";
    public static final String USER = BASE + "/user/{username}";
//    public static final String ADD_USER = BASE + "/user/add/{fName}/{lName}/{alias}/{email}";
    public static final String ADD_USER = BASE + "/user/add/{fName}/{lName}/{alias}/{email}/{type}";

}
