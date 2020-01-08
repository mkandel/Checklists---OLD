/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.controllers;

import com.mkandel.checklists.utils.EmailValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.mkandel.checklists.utils.Routes.*;

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

    @RequestMapping(HEALTH)
    public HashMap<String, String> health(){
        HashMap ret = new HashMap<String, String>();
        ret.put("status", "ok");
        return ret;
    }

//    @RequestMapping(TEAPOT)
//    public HttpStatus teapot(){
//        return HttpStatus.I_AM_A_TEAPOT;
//    }

    @GetMapping(VALIDATE_EMAIL)
    public Map<String, String> validateEmail(@PathVariable String email){
        EmailValidator emailValidator = new EmailValidator();
        Map<String, String> ret = new HashMap<>();
        ret.put("email", email);
        if (EmailValidator.validateEmail(email)){
//            System.out.println("* Email validated: " + email);
            ret.put("status", "ok");
        } else {
//            System.out.println("* Email NOT validated: " + email);
            ret.put("status", "invalid");
        }
        return ret;
    }

    @GetMapping(USER_TYPES)
    public Map<String, String> listTypes(){
        Map<String, String> ret = new HashMap<>();
        return ret;
    }
}
