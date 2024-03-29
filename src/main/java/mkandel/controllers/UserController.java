/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel.controllers;

import mkandel.entities.User;
import mkandel.outbound.DbAdapter;
import mkandel.utils.InvalidEmailException;
import mkandel.utils.UserTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        UserTypes actualType;
        if(intType == 0){
            actualType = UserTypes.ADMIN;
        } else if (intType == 1){
            actualType = UserTypes.CREATOR;
        } else {
            actualType = UserTypes.USER;
        }
        user.setType(actualType);
        user.setActive(true);
        // TODO: save() user which should update id with DB assigned id
        user.setId(java.util.UUID.randomUUID());
        return user;
    }
}
