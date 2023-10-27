package com.example.uek295_backeend.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for user login operations.
 * It contains fields for the username and password required for authentication.
 */
public class LoginDTO {

    @NotBlank  // This field cannot be blank during validation
    private String userName;

    @NotBlank  // This field cannot be blank during validation
    private String password;

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     *
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
