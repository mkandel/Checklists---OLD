/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.inbound.dtos.UserDto;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.stream.Collectors.toList;

public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;

    public User toUser(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    public UserDto toUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> toUserDto(List<User> users) {
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(toList());
    }

    public UserDto toUserDto(Optional<User> optionalUser) {

        return toUserDto(optionalUser.get());
    }
}
