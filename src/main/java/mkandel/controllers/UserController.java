/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.controllers;

import mkandel.entities.*;
import mkandel.outbound.*;
import mkandel.utils.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static mkandel.utils.Routes.*;

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
    public User user(@PathVariable String username) throws Exception {
        User user = dbAdapter.getUser(username);
        return user;
    }

    @PutMapping(ADD_USER)
    public User addUser(@PathVariable String fName,
                        @PathVariable String lName,
                        @PathVariable String username,
                        @PathVariable String email,
                        @PathVariable String type
    ) throws InvalidEmailException {
        User user = new User();
        user.setfName(fName);
        user.setlName(lName);
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
        user.setId(java.util.UUID.randomUUID());
        return user;
    }
}
