package com.example.java.rest.api.service;

import org.springframework.stereotype.Service;

import com.example.java.rest.api.error.DuplicateUserException;
import com.example.java.rest.api.model.User;


public interface AuthenticationService {
    
    public User signup(User user) throws DuplicateUserException;

}
