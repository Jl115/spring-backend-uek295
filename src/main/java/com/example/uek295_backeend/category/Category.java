package com.example.uek295_backeend.category;

import jakarta.persistence.*;

/**
 * Entity representing a category in the application.
 * It contains fields for the ID, name, and activity status of a category.
 */
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // The unique identifier for the category

    @Column(length = 255)
    private String name;  // The name of the category

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0")
    private Integer active = 0;  // The activity status of the category (e.g., 1 for active, 0 for inactive)

    /**
     * Gets the unique identifier of the category.
     *
     * @return The ID of the category.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the category.
     *
     * @param id The ID to set for the category.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the category.
     *
     * @return The name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name The name to set for the category.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the activity status of the category.
     *
     * @return The activity status of the category.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Sets the activity status of the category.
     *
     * @param active The activity status to set for the category.
     */
    public void setActive(Integer active) {
        this.active = active;
    }
}
