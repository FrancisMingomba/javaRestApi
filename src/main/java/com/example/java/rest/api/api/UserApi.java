package com.example.java.rest.api.api;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.rest.api.error.DuplicateUserException;
import com.example.java.rest.api.model.User;
import com.example.java.rest.api.repository.UserRepository;
import com.example.java.rest.api.service.AuthenticationService;

@RestController
@RequestMapping("")
public class UserApi {

    //private static final  UserRepository userRepository = null;

    @Autowired 
    AuthenticationService authenticationService;

    @PostMapping("/users")
    public User signup(@RequestBody User userFromClient) throws DuplicateUserException{
            return authenticationService.signup(userFromClient);
     
    }
    
}
