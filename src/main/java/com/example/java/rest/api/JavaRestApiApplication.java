package com.example.java.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.client.MongoClient;

@SpringBootApplication
public class JavaRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRestApiApplication.class, args);
			
		
		System.out.println("Connected to mongodb");  
	
	}

}
