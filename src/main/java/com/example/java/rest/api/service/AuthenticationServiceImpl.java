package com.example.java.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.rest.api.error.DuplicateUserException;
import com.example.java.rest.api.model.User;
import com.example.java.rest.api.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;


    public User signup(User userFromClientUser) throws DuplicateUserException {
        if  (alreadyExists(userFromClientUser))
        throw new DuplicateUserException(" User already exists!");
    

    return this.userRepository.save(userFromClientUser);
    
    }


    private boolean alreadyExists(User user) {
        return this.userRepository.findUserByEmail(user.getEmail()) != null;
    }
}