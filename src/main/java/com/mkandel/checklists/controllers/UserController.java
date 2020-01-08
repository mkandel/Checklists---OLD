/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.controllers;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.outbound.DbAdapter;
import com.mkandel.checklists.utils.InvalidEmailException;
import com.mkandel.checklists.utils.UserType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mkandel.checklists.utils.Routes.*;

@RestController
public class UserController {
    DbAdapter dbAdapter;

    public UserController() {
        try {
            this.dbAdapter = new DbAdapter();
        } catch (Exception ex) {
            // TODO: do something better with this exception ...
//            throw ex;
        }
    }

    /**
     *  /api/v1/users endpoint:
     *          @Returns: List of all users in the system
     *
     * @TODO: Permissions, restrict users to only see what they have access to
     */
    @GetMapping(USERS)
    public List<User> users() throws Exception {
        List<User> users = dbAdapter.getUsers();
        return users;
    }

    @GetMapping(USER)
    public User userById(@PathVariable String id) throws Exception {
        User user = dbAdapter.getUser(id);
        return user;
    }

    @GetMapping(USER_BY_USERNAME)
    public User userByUsername(@PathVariable String username) throws Exception {
        User user = dbAdapter.getUserByUsername(username);
        return user;
    }

    @PutMapping(ADD_USER)
    public User addUser(@PathVariable String Fname,
                        @PathVariable String Lname,
                        @PathVariable String username,
                        @PathVariable String email,
                        @PathVariable String type
    ) throws InvalidEmailException {
        User user = new User();
        user.setFname(Fname);
        user.setLname(Lname);
        user.setUsername(username);
        user.setEmail(email);
        int intType = Integer.parseInt(type);
        UserType actualType;
        if(intType == 0){
            actualType = UserType.ADMIN;
        } else if (intType == 1){
            actualType = UserType.CREATOR;
        } else {
            actualType = UserType.USER;
        }
        user.setType(actualType);
        user.setActive(true);
        // TODO: save() userByUsername which should update id with DB assigned id
        user.setId(java.util.UUID.randomUUID().toString());
        return user;
    }
}
