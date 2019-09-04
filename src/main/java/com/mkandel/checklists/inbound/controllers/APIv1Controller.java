/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.utils.EmailValidator;
import com.mkandel.checklists.utils.Routes;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIv1Controller {

    @RequestMapping(Routes.BASE)
    public String apiRoot() {
        return "Welcome to the API version 1!";
    }

    @RequestMapping(Routes.HEALTH)
    public HashMap<String, String> health() {
        final HashMap<String, String> ret = new HashMap<>();
        ret.put("status", "ok");
        return ret;
    }

    @RequestMapping(Routes.TEAPOT)
    public HttpStatus teapot() {
        return HttpStatus.I_AM_A_TEAPOT;
    }

    @GetMapping(Routes.VALIDADTE_EMAIL)
    public Map<String, String> validateEmail(@PathVariable String email) {
        final EmailValidator emailValidator = new EmailValidator();
        final Map<String, String> ret = new HashMap<>();
        ret.put("email", email);
        if (emailValidator.validateEmail(email)) {
            ret.put("status", "ok");
        } else {
            ret.put("status", "invalid");
        }
        return ret;
    }

    @GetMapping(Routes.USER_TYPES)
    public Map<String, String> listTypes() {
        return new HashMap<>();
    }
}
