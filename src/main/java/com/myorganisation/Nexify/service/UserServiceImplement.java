package com.myorganisation.Nexify.service;

import com.myorganisation.Nexify.dto.genericresponsedto.GenericResponseDto;
import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;

import java.util.List;

public class UserServiceImplement implements UserService{
    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto getUser(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        return List.of();
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public GenericResponseDto deleteUser(Long id) {
        return null;
    }
}
