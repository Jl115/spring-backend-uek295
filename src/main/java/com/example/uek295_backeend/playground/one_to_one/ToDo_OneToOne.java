/*
package com.example.uek295_backeend.playground.one_to_one;


import com.example.uek295_backeend.playground.one_to_one.ToDoList;
import jakarta.persistence.*;


@Entity
public class ToDo_OneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String title;

    @Column(columnDefinition = "VARCHAT(255)", nullable = false)
    private String todo;


    @Enumerated(EnumType.ORDINAL)
    private TodoType todoType = TodoType.NORMAL;

    @OneToOne()
    private ToDoList toDoList;

}
*/
