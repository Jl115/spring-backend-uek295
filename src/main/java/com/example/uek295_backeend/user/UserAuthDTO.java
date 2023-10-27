package com.example.uek295_backeend.user;

import com.example.uek295_backeend.user.UserDTO;

/**
 * Data Transfer Object (DTO) for user authentication and related operations.
 * This class extends from {@link UserDTO} and includes additional fields required for authentication.
 */
public class UserAuthDTO extends UserDTO {

    /**
     * Flag indicating if the user has admin rights.
     */
    private byte admin;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * Associated channel ID.
     */
    private int ChannelID;

    /**
     * Associated product ID.
     */
    private int productID;

    /**
     * Retrieves the admin flag.
     *
     * @return the admin flag.
     */
    public byte getAdmin() {
        return admin;
    }

    /**
     * Sets the admin flag.
     *
     * @param admin the admin flag.
     */
    public void setAdmin(byte admin) {
        this.admin = admin;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the associated channel ID.
     *
     * @return the associated channel ID.
     */
    public int getChannelID() {
        return ChannelID;
    }

    /**
     * Sets the associated channel ID.
     *
     * @param channelID the associated channel ID.
     */
    public void setChannelID(int channelID) {
        ChannelID = channelID;
    }

    /**
     * Retrieves the associated product ID.
     *
     * @return the associated product ID.
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the associated product ID.
     *
     * @param productID the associated product ID.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }
}
