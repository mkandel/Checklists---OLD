/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import java.util.HashMap;
import java.util.Map;
import mkandel.utils.EmailValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static mkandel.utils.Routes.BASE;
import static mkandel.utils.Routes.HEALTH;
import static mkandel.utils.Routes.TEAPOT;
import static mkandel.utils.Routes.USER_TYPES;
import static mkandel.utils.Routes.VALIDADTE_EMAIL;

@RestController
public class APIv1Controller {

    /**
     *  /api/v1/users endpoint:
     *          @Returns: List of all users in the system
     *
     *  @TODO: Permissions, restrict users to only see what they have access to
     *
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

    @RequestMapping(TEAPOT)
    public HttpStatus teapot(){
        return HttpStatus.I_AM_A_TEAPOT;
    }

    @GetMapping(VALIDADTE_EMAIL)
    public Map<String, String> validateEmail(@PathVariable String email){
        EmailValidator emailValidator = new EmailValidator();
        Map<String, String> ret = new HashMap<>();
        ret.put("email", email);
        if (emailValidator.validateEmail(email)){
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
