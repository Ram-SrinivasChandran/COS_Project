package net.breezeware.food.entity;

/**
 * Represents a mapping between a food menu and a food item in the system.
 */
public class FoodMenuFoodItemMap {
    private int id;             // Unique identifier for the mapping.
    private FoodMenu foodMenuId;  // The food menu associated with the mapping.
    private FoodItem foodItemId;  // The food item associated with the mapping.

    /**
     * Constructs a new instance of FoodMenuFoodItemMap.
     *
     * @param id         The unique identifier for the mapping.
     * @param foodMenuId The food menu associated with the mapping.
     * @param foodItemId The food item associated with the mapping.
     */
    public FoodMenuFoodItemMap(int id, FoodMenu foodMenuId, FoodItem foodItemId) {
        this.id = id;
        this.foodMenuId = foodMenuId;
        this.foodItemId = foodItemId;
    }

    /**
     * Get the unique identifier for the mapping.
     *
     * @return The identifier for the mapping.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier for the mapping.
     *
     * @param id The identifier for the mapping.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the food menu associated with the mapping.
     *
     * @return The food menu associated with the mapping.
     */
    public FoodMenu getFoodMenuId() {
        return foodMenuId;
    }

    /**
     * Set the food menu associated with the mapping.
     *
     * @param foodMenuId The food menu associated with the mapping.
     */
    public void setFoodMenuId(FoodMenu foodMenuId) {
        this.foodMenuId = foodMenuId;
    }

    /**
     * Get the food item associated with the mapping.
     *
     * @return The food item associated with the mapping.
     */
    public FoodItem getFoodItemId() {
        return foodItemId;
    }

    /**
     * Set the food item associated with the mapping.
     *
     * @param foodItemId The food item associated with the mapping.
     */
    public void setFoodItemId(FoodItem foodItemId) {
        this.foodItemId = foodItemId;
    }
}
