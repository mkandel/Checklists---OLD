/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.exceptions.UserNotFoundException;
import com.mkandel.checklists.inbound.converters.UserConverter;
import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.outbound.repositories.UserRepository;
import com.mkandel.checklists.utils.Routes;
import com.mkandel.checklists.utils.UserType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mkandel.checklists.inbound.converters.UserConverter.toUserDto;
import static java.util.stream.Collectors.toList;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    private UserConverter userConverter = new UserConverter();

    @GetMapping(value = Routes.USERNAMES)
    public List<String> usernames() {
        return userRepository.findAll()
                .stream()
                .map(User::getUsername)
                .collect(toList());
    }

    @GetMapping(value = Routes.USERS, produces = UserDto.JSON_MIME_TYPE)
    public List<UserDto> users() throws Exception {
        return toUserDto(userRepository.findAll());
    }

    @GetMapping(value = Routes.USER, produces = UserDto.JSON_MIME_TYPE)
    public UserDto user(@PathVariable String username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return toUserDto(optionalUser.get());
        } else {
            throw new UserNotFoundException("No such user : '" +username + "'");
        }
    }

    @PutMapping(value = Routes.ADD_USER, consumes = UserDto.JSON_MIME_TYPE, produces = UserDto.JSON_MIME_TYPE)
    public UserDto addUser(@PathVariable String Fname,
                        @PathVariable String Lname,
                        @PathVariable String username,
                        @PathVariable String email,
                        @PathVariable String type
    ) {
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
        return toUserDto(userRepository.save(user));
    }
}
