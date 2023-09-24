/*package com.example.uek295_backeend.playground.one_to_one;

import jakarta.persistence.*;

@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(columnDefinition = "varchar(255)")
    private String title;

    @OneToOne(mappedBy = "toDoList")
    private ToDo_OneToOne toDoOneToOne;
}

 */
