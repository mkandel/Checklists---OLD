/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import java.util.*;
import mkandel.entities.*;
import mkandel.outbound.*;
import mkandel.outbound.repositories.UserRepository;
import mkandel.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static mkandel.utils.Routes.*;

@RestController
public class UserController {
    DbAdapter dbAdapter;

    @Autowired
    UserRepository userRepository;

    public UserController() {
        try {
            this.dbAdapter = new DbAdapter();
        } catch (Exception ex) {
            // TODO: do something better with this exception ...
            System.out.println("*** GRRRRRRRR ***");
            throw ex;
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
//        List<User> users = dbAdapter.getUsers();
//        return users;
        return userRepository.findAll();
    }

    @GetMapping(USER)
    public User user(@PathVariable String username) throws Exception {
        return userRepository.findByUsername(username);
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
        // TODO: save() user which should update id with DB assigned id
//        user.setId(java.util.UUID.randomUUID());
        return user;
    }
}
