package com.example.java.rest.api.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMassage {
      private HttpStatus status;
      private String message;  
}
