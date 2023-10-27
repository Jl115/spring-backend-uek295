package com.example.uek295_backeend.category;

/**
 * Data Transfer Object (DTO) for category-related operations.
 * It contains fields for the name and activity status of a category.
 */
public class CategoryDTO {

    private String name;  // The name of the category
    private Integer active;  // The activity status of the category (e.g., 1 for active, 0 for inactive)

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
