package com.example.uek295_backeend.channel;

import com.example.uek295_backeend.user.User;
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
    private User userId1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User userId2;

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

    public User getUserId1() {
        return userId1;
    }

    public void setUserId1(User userId1) {
        this.userId1 = userId1;
    }

    public User getUserId2() {
        return userId2;
    }

    public void setUserId2(User userId2) {
        this.userId2 = userId2;
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

