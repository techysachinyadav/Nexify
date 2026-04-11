package com.myorganisation.Nexify.service;

import com.myorganisation.Nexify.dto.genericresponsedto.GenericResponseDto;
import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto registerUser(UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> getAllUser();
    UserResponseDto updateUser(Long id , UserRequestDto userRequestDto );
    GenericResponseDto deleteUser(Long id);
}
