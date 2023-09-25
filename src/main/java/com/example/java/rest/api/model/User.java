package com.example.java.rest.api.model;


import lombok.Builder;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;


@Data
@Builder
//@Entity

@Document("users")
public class User {
    private String name;
    private String password;
    private String email;
}