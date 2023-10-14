package com.example.uek295_backeend.user;

//TODO ASK THE TEACHER IF THE UserDTO NEEDS ID'S

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class UserDTO {

    private Integer userId;
    private String name;
    private String description;
    private String image;
    private byte active;


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
