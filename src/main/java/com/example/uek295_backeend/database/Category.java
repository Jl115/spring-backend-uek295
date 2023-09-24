package com.example.uek295_backeend.database;

import jakarta.persistence.*;


@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private byte active;

    @Column(length = 255)
    private String name;
}