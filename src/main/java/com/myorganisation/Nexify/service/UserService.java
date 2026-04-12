package com.myorganisation.Nexify.service;

import com.myorganisation.Nexify.dto.genericresponsedto.GenericResponseDto;
import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface UserService {
    UserResponseDto registerUser(UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> getAllUser();
    UserResponseDto updateUser(Long id , UserRequestDto userRequestDto );
    GenericResponseDto deleteUser(Long id);
}
