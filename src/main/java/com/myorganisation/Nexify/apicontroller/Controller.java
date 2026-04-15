package com.myorganisation.Nexify.apicontroller;

import com.myorganisation.Nexify.dto.genericresponsedto.GenericResponseDto;
import com.myorganisation.Nexify.dto.userrequestdto.UserRequestDto;
import com.myorganisation.Nexify.dto.userresponsedto.UserResponseDto;
import com.myorganisation.Nexify.repository.UserRepository;
import com.myorganisation.Nexify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(userService.getUser(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> getAllUsers (){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUser (@PathVariable Long id , @RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.updateUser(id , userRequestDto),HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseDto> deleteUser (@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<List<UserResponseDto>> searchByUsername (@PathVariable String username){
        return new ResponseEntity<>(userService.findByUsernameContaining(username),HttpStatusCode.valueOf(200));
    }

}
