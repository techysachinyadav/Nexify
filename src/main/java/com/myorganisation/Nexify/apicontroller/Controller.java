package com.myorganisation.Nexify.apicontroller;

import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;
import com.myorganisation.Nexify.repository.UserRepository;
import com.myorganisation.Nexify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser (@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.registerUser(userRequestDto ), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser (@PathVariable Long id ){
        return new ResponseEntity<>(userService.getUser(id),HttpStatusCode.valueOf(200));a
    }


}
