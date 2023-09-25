package net.breezeware.order.dto;

/**
 * The DisplayFoodItemDto class represents a data transfer object for displaying a food item in an order.
 */
public class DisplayFoodItemDto {

    /**
     * The FoodItemDto associated with the displayed food item.
     */
    private FoodItemDto foodItemDto;

    /**
     * The name of the displayed food item.
     */
    private String foodItemName;

    /**
     * Constructs a DisplayFoodItemDto with the specified FoodItemDto and food item name.
     *
     * @param foodItemDto   The FoodItemDto associated with the displayed food item.
     * @param foodItemName  The name of the displayed food item.
     */
    public DisplayFoodItemDto(FoodItemDto foodItemDto, String foodItemName) {
        this.foodItemDto = foodItemDto;
        this.foodItemName = foodItemName;
    }

    /**
     * Gets the FoodItemDto associated with the displayed food item.
     *
     * @return The FoodItemDto associated with the displayed food item.
     */
    public FoodItemDto getFoodItemDto() {
        return foodItemDto;
    }

    /**
     * Sets the FoodItemDto associated with the displayed food item.
     *
     * @param foodItemDto The FoodItemDto to be associated with the displayed food item.
     */
    public void setFoodItemDto(FoodItemDto foodItemDto) {
        this.foodItemDto = foodItemDto;
    }

    /**
     * Gets the name of the displayed food item.
     *
     * @return The name of the displayed food item.
     */
    public String getFoodItemName() {
        return foodItemName;
    }

    /**
     * Sets the name of the displayed food item.
     *
     * @param foodItemName The name of the displayed food item to be set.
     */
    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }
}
