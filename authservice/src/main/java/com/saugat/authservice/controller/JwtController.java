package com.saugat.authservice.controller;

import com.saugat.authservice.dto.UserDto;
import com.saugat.authservice.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class JwtController {

    private final JwtService service;

    public JwtController(JwtService jwtService) {
        this.service = jwtService;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> getToken(@RequestBody UserDto user){

        String accessToken = service.generateToken(user);
        Map<String, String> userToken = new HashMap<>();
        userToken.put("accessToken", accessToken);
        userToken.put("email", user.getEmail());
        return new ResponseEntity<Map<String, String>>(userToken, HttpStatus.OK);
    }
}
