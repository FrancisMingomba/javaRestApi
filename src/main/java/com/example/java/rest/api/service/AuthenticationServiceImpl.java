package com.example.java.rest.api.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.java.rest.api.error.DuplicateUserException;
import com.example.java.rest.api.model.User;
import com.example.java.rest.api.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordIncryption passwordIncryption;

    public User signup(User userFromClientUser) throws DuplicateUserException {
        if (alreadyExists(userFromClientUser)) {
            throw new DuplicateUserException(" User already exists!!!!");
        }

        String password = passwordIncryption.password(userFromClientUser);
        userFromClientUser.setPassword(password);

        return this.userRepository.save(userFromClientUser);

    }

    private boolean alreadyExists(User user) {
        return this.userRepository.findUserByEmail(user.getEmail()) != null;
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> userIdb = this.userRepository.findAll();
        List<User> data = convertUsersToList(userIdb);
        return data;

    }

    private List<User> convertUsersToList(Iterable<User> users) {
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

}