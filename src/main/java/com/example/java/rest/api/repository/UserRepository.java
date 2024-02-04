package com.example.java.rest.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.java.rest.api.model.User;


    public interface UserRepository extends MongoRepository<User, String> {
        User findUserByEmail(String email);
    }

    

