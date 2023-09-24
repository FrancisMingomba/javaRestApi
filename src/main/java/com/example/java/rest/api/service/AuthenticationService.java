package com.example.java.rest.api.service;

import java.util.List;

import com.example.java.rest.api.error.DuplicateUserException;
import com.example.java.rest.api.model.User;


public interface AuthenticationService {
    
    public User signup(User user) throws DuplicateUserException;

    List<User> getAllUsers();

}
