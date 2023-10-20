package com.example.java.rest.api.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.java.rest.api.model.User;

@Service
public class PasswordIncryptionImpl implements PasswordIncryption {

    @Override
    public String password(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(),
                BCrypt.gensalt(10));
        return hashedPassword;
    }

}
