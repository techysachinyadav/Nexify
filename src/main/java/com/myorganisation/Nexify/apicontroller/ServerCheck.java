package com.myorganisation.Nexify.apicontroller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ServerCheck {
    @GetMapping("/")

    public ResponseEntity<String> serverTest(){
        return new ResponseEntity<>("Server is live...", HttpStatusCode.valueOf(200));
    }
}
