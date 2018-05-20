/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.controllers;

import hello.entities.User;
import hello.outbound.DbAdapter;
import hello.utils.InvalidEmailException;
import hello.utils.UserTypesEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static hello.utils.Routes.*;

@RestController
public class UserController {

    /**
     *  /api/v1/users endpoint:
     *          @Returns: List of all users in the system
     *
     * @TODO: Permissions, restrict users to only see what they have access to
     */
    @GetMapping(USERS)
    public User[] users(){
        return new User[0];
    }

    @GetMapping(USER)
    public User user(@PathVariable String username) throws Exception {
        DbAdapter dbAdapter = new DbAdapter();
        User user = dbAdapter.getUser(username);
        return user;
    }

    @PutMapping(ADD_USER)
    public User addUser(@PathVariable String fName,
                        @PathVariable String lName,
                        @PathVariable String alias,
                        @PathVariable String email,
                        @PathVariable UserTypesEnum type
    ) throws InvalidEmailException {
        User user = new User();
        user.setfName(fName);
        user.setlName(lName);
        user.setUsername(alias);
        user.setEmail(email);
        user.setType(type);
        user.setActive(true);
        return user;
    }
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World!!!") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
}
