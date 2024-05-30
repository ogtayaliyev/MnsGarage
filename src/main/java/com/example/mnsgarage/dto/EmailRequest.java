package com.example.mnsgarage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {

    private String email;
    private String to;
    private String subject;
    private String message;

    // Getters and setters
}
