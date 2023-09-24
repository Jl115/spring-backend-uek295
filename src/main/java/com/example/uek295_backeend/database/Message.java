package com.example.uek295_backeend.database;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity


@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @Column(name = "message_send")
    private Timestamp messageSend;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String messageContent;


}

