package com.example.uek295_backeend.user;

import com.example.uek295_backeend.product.Product;
import jakarta.persistence.*;

import java.util.List;


/**
 * Entity representation of a user.
 */
@Entity
@Table(name = "User")
public class User {

    /**
     * The unique ID of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    /**
     * The name of the user.
     */
    @Column(length = 500)
    private String name;

    /**
     * The password of the user.
     */
    @Column(length = 256)
    private String password;

    /**
     * Description associated with the user.
     */
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    /**
     * List of products associated with the user.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products;

    /**
     * Image or avatar associated with the user.
     */
    @Column(length = 1000)
    private String image;

    /**
     * Flag indicating if the user is active.
     */
    @Column
    private byte active;

    /**
     * Flag indicating if the user has admin rights.
     */
    @Column
    private boolean isAdmin;

    /**
     * Associated channel ID.
     * Note: You might need to provide more details or create a relationship with a Channel entity.
     */
    private int channelId;

    /**
     * Associated product ID.
     * Note: You might need to provide more details or create a relationship with a Product entity.
     */
    private int productId;

    //Getters and Setters


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }
}