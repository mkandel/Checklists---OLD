/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.exceptions.UserNotFoundException;
import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.outbound.repositories.UserRepository;
import com.mkandel.checklists.utils.Routes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.mkandel.checklists.inbound.converters.UserConverter.toUser;
import static com.mkandel.checklists.inbound.converters.UserConverter.toUserDto;
import static java.util.stream.Collectors.toList;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = Routes.USERNAMES)
    public List<String> usernames() {
        return userRepository.findAll()
                .stream()
                .map(User::getUsername)
                .collect(toList());
    }

    @GetMapping(value = Routes.USERS, produces = UserDto.JSON_MIME_TYPE)
    public List<UserDto> users() {
        return toUserDto(userRepository.findAll());
    }

    @GetMapping(value = Routes.USER, produces = UserDto.JSON_MIME_TYPE)
    public UserDto user(@PathVariable String username) throws UserNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return toUserDto(optionalUser.get());
        } else {
            throw new UserNotFoundException("No such user : '" + username + "'");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = Routes.USERS, consumes = UserDto.JSON_MIME_TYPE, produces = UserDto.JSON_MIME_TYPE)
    public UserDto addUser(@RequestBody UserDto dto) {
        return toUserDto(userRepository.save(toUser(dto)));
    }
}
