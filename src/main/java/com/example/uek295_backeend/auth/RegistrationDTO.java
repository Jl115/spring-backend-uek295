package com.example.uek295_backeend.auth;

import jakarta.validation.constraints.NotBlank;

public class RegistrationDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
