package com.myorganisation.Nexify.service;

import com.myorganisation.Nexify.dto.genericresponsedto.GenericResponseDto;
import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;
import com.myorganisation.Nexify.entity.MetaData;
import com.myorganisation.Nexify.entity.Profile;
import com.myorganisation.Nexify.entity.User;
import com.myorganisation.Nexify.repository.MetaDataRepository;
import com.myorganisation.Nexify.repository.ProfileRepository;
import com.myorganisation.Nexify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service

public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private MetaDataRepository metaDataRepository;



    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
    User user = mapRequestDtoToUser(userRequestDto , new User());
        Profile profile = new Profile();
        profile.setUser(user);
        user.setProfile(profile);
        MetaData metaData = new MetaData();
        metaDataRepository.save(metaData);
        user.setMetaData(metaData);
        metaData.setUser(user);
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
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();

        for (User user : userList){
            userResponseDtoList.add(mapUserToResponseDto(user));
        }

        return userResponseDtoList;

    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null){
            mapRequestDtoToUser(userRequestDto,user);
            userRepository.save(user);
            return mapUserToResponseDto(user);
        }
        else {
            return null;
        }
    }

    @Override
    public GenericResponseDto deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        if (user != null){
            userRepository.deleteById(id);
            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage("User deleted successfully");
            genericResponseDto.setDetails(user);
            return genericResponseDto;
        }
        else{
             genericResponseDto.setMessage("User not found");
             return genericResponseDto;
        }
    }

    @Override
    public List<UserResponseDto> findByUsernameContaining(String username) {
        List<User> userList = userRepository.findByUsernameContaining(username);
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();
        for (User user : userList ) {
            userResponseDtoList.add(mapUserToResponseDto(user));
        }
        return userResponseDtoList;
    }

    private UserResponseDto mapUserToResponseDto (User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setGender(user.getGender());
        userResponseDto.setProfile(user.getProfile());
        userResponseDto.setMetadata(user.getMetaData());

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
