package com.example.java.rest.api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.rest.api.error.DuplicateUserException;
import com.example.java.rest.api.model.User;
import com.example.java.rest.api.service.AuthenticationService;

@RestController
@RequestMapping("")
public class UserApi {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/users")
    public User signup(@RequestBody User userFromClient) throws DuplicateUserException {
        return authenticationService.signup(userFromClient);

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(authenticationService.getAllUsers());
    }

}
