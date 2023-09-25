package net.breezeware.order.dto;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.util.List;

/**
 * The ViewFoodMenuDto class represents a data transfer object for viewing a food menu along with its associated food items.
 */
public class ViewFoodMenuDto {

    /**
     * The food menu associated with the DTO.
     */
    private FoodMenu foodMenu;

    /**
     * The list of food items included in the food menu.
     */
    private List<FoodItem> foodItems;

    /**
     * Constructs a ViewFoodMenuDto with the specified food menu and list of food items.
     *
     * @param foodMenu   The food menu to be viewed.
     * @param foodItems  The list of food items included in the food menu.
     */
    public ViewFoodMenuDto(FoodMenu foodMenu, List<FoodItem> foodItems) {
        this.foodMenu = foodMenu;
        this.foodItems = foodItems;
    }

    /**
     * Gets the food menu associated with the DTO.
     *
     * @return The food menu associated with the DTO.
     */
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    /**
     * Sets the food menu associated with the DTO.
     *
     * @param foodMenu The food menu to be set.
     */
    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    /**
     * Gets the list of food items included in the food menu.
     *
     * @return The list of food items.
     */
    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    /**
     * Sets the list of food items included in the food menu.
     *
     * @param foodItems The list of food items to be set.
     */
    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
