package com.myorganisation.Nexify.service;

import com.myorganisation.Nexify.dto.genericresponsedto.GenericResponseDto;
import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;
import com.myorganisation.Nexify.entity.User;
import com.myorganisation.Nexify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
    User user = mapRequestDtoToUser(userRequestDto , new User());
        userRepository.save(user);
        return mapUserToResponseDto(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            return mapUserToResponseDto(user);
        }
        else {
            return null;
        }
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

    private UserResponseDto mapUserToResponseDto (User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setGender(user.getGender());

        return userResponseDto;
    }

    private User mapRequestDtoToUser(UserRequestDto userRequestDto , User user){
        user.setName(userRequestDto.getName());
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setGender(userRequestDto.getGender());

        return user;

    }
}
