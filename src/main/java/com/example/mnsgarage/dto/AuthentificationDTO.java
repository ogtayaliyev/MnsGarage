package com.example.mnsgarage.dto;

public record AuthentificationDTO(String email, String password) {
    public String getEmail() {
        return email;
    }

    public Object getPassword() {
        return  password;
    }
}
