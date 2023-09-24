package com.example.uek295_backeend.database;

import jakarta.persistence.*;


@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 500)
    private String name;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(length = 1000)
    private String image;

    private byte active;

    private int channelId;

    private int productId;
}