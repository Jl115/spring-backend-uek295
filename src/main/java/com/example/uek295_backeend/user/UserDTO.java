package com.example.uek295_backeend.user;

//TODO ASK THE TEACHER IF THE UserDTO NEEDS ID'S



/**
 * Data Transfer Object (DTO) for user operations.
 * This class provides a simplified representation of the User entity for transfer between
 * the application and the client.
 */
public class UserDTO {

    /**
     * The unique ID of the user.
     */
    private Integer userId;

    /**
     * The name of the user.
     */
    private String name;

    /**
     * Description associated with the user.
     */
    private String description;

    /**
     * Image or avatar associated with the user.
     */
    private String image;

    /**
     * Flag indicating if the user is active.
     */
    private byte active;

    // Getters, setters, and other methods can be added as needed.

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }
}
