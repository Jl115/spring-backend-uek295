package com.example.uek295_backeend.user;

import com.example.uek295_backeend.user.UserDTO;

public class UserAuthDTO extends UserDTO {

    private byte admin;
    private String password;
    private int ChannelID;
    private int productID;

    public byte getAdmin() {
        return admin;
    }

    public void setAdmin(byte admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChannelID() {
        return ChannelID;
    }

    public void setChannelID(int channelID) {
        ChannelID = channelID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
