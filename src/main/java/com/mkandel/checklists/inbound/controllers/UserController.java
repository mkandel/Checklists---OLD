/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.inbound.converters.UserConverter;
import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.outbound.DbAdapter;
import com.mkandel.checklists.outbound.repositories.UserRepository;
import com.mkandel.checklists.utils.InvalidEmailException;
import com.mkandel.checklists.utils.Routes;
import com.mkandel.checklists.utils.UserType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    DbAdapter dbAdapter;

    @Autowired
    UserRepository userRepository;

    UserConverter userConverter = new UserConverter();

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
    @GetMapping(value = Routes.USERS, produces = UserDto.JSON_MIME_TYPE)
    public List<UserDto> users() throws Exception {
//        List<User> users = dbAdapter.getUsers();
//        return users;
        return userConverter.toUserDto(userRepository.findAll());
    }

    @GetMapping(value = Routes.USER, produces = UserDto.JSON_MIME_TYPE)
    public Optional<UserDto> user(@PathVariable String username) throws Exception {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return Optional.of(userConverter.toUserDto(optionalUser.get()));
    }

    @PutMapping(value = Routes.ADD_USER, consumes = UserDto.JSON_MIME_TYPE, produces = UserDto.JSON_MIME_TYPE)
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
