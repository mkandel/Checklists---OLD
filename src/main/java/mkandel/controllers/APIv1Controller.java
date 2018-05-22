/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static mkandel.utils.Routes.BASE;

@RestController
public class APIv1Controller {

    /**
     *  /api/v1/users endpoint:
     *          @Returns: List of all users in the system
     *
     * @TODO: Permissions, restrict users to only see what they have access to
     */
    @RequestMapping(BASE)
    public String apiRoot(){
        return "Welcome to the API version 1!";
    }
}
