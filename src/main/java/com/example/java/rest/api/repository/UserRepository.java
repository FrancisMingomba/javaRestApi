package com.example.java.rest.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.example.java.rest.api.model.User;


    public interface UserRepository extends MongoRepository<User, String> {
        User findUserByEmail(String email);
    }

    

