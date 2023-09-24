package com.example.uek295_backeend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity
@Table(name = "Channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    @Column(length = 500)
    private String name;


    @Column(name = "channel_create")
    private Timestamp channelCreate;

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getChannelCreate() {
        return channelCreate;
    }

    public void setChannelCreate(Timestamp channelCreate) {
        this.channelCreate = channelCreate;
    }
}

