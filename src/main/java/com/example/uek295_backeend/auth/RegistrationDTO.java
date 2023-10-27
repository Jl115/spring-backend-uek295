package com.example.uek295_backeend.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for user registration operations.
 * It contains fields for the username and password required for registration.
 */
public class RegistrationDTO {

    @NotBlank  // This field cannot be blank during validation
    private String name;

    @NotBlank  // This field cannot be blank during validation
    private String password;

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the username.
     *
     * @param name The username to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
