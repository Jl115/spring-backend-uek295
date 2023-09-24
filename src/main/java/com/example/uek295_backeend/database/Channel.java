package com.example.uek295_backeend.database;

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

}

