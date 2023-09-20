package net.breezeware.food.dto;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.util.List;

/**
 * Data Transfer Object (DTO) that represents a food menu along with its associated food items.
 */
public class FoodMenuDto {
    private FoodMenu foodMenu;        // The food menu object.
    private List<FoodItem> foodItems; // The list of associated food items.

    /**
     * Constructs a new instance of FoodMenuDto.
     *
     * @param foodMenu   The food menu object.
     * @param foodItems  The list of associated food items.
     */
    public FoodMenuDto(FoodMenu foodMenu, List<FoodItem> foodItems) {
        this.foodMenu = foodMenu;
        this.foodItems = foodItems;
    }

    /**
     * Get the food menu object.
     *
     * @return The food menu object.
     */
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    /**
     * Set the food menu object.
     *
     * @param foodMenu The food menu object.
     */
    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    /**
     * Get the list of associated food items.
     *
     * @return The list of associated food items.
     */
    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    /**
     * Set the list of associated food items.
     *
     * @param foodItems The list of associated food items.
     */
    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
