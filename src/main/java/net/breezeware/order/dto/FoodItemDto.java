package net.breezeware.order.dto;

/**
 * The FoodItemDto class represents a data transfer object for a food item in an order.
 */
public class FoodItemDto {

    /**
     * The ID of the food item.
     */
    private int foodItemId;

    /**
     * The quantity of the food item.
     */
    private int foodItemQuantity;

    /**
     * The cost of the food item.
     */
    private double foodCost;

    /**
     * The total quantity of the food item.
     */
    private int totalQuantity;
    private String foodItemName;

    /**
     * Constructs a FoodItemDto with the specified food item ID, quantity, and cost.
     *
     * @param foodItemId       The ID of the food item.
     * @param foodItemQuantity The quantity of the food item.
     * @param foodCost         The cost of the food item.
     */
    public FoodItemDto(int foodItemId, int foodItemQuantity, double foodCost) {
        this.foodItemId = foodItemId;
        this.foodItemQuantity = foodItemQuantity;
        this.foodCost = foodCost;
    }

    /**
     * Constructs a FoodItemDto with the specified food item ID and quantity.
     *
     * @param foodItemId       The ID of the food item.
     * @param foodItemQuantity The quantity of the food item.
     */
    public FoodItemDto(int foodItemId, int foodItemQuantity) {
        this.foodItemId = foodItemId;
        this.foodItemQuantity = foodItemQuantity;
    }

    /**
     * Gets the ID of the food item.
     *
     * @return The food item ID.
     */
    public int getFoodItemId() {
        return foodItemId;
    }

    /**
     * Sets the ID of the food item.
     *
     * @param foodItemId The food item ID to be set.
     */
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    /**
     * Gets the quantity of the food item.
     *
     * @return The quantity of the food item.
     */
    public int getFoodItemQuantity() {
        return foodItemQuantity;
    }

    /**
     * Sets the quantity of the food item.
     *
     * @param foodItemQuantity The quantity of the food item to be set.
     */
    public void setFoodItemQuantity(int foodItemQuantity) {
        this.foodItemQuantity = foodItemQuantity;
    }

    /**
     * Gets the cost of the food item.
     *
     * @return The cost of the food item.
     */
    public double getFoodCost() {
        return foodCost;
    }

    /**
     * Sets the cost of the food item.
     *
     * @param foodCost The cost of the food item to be set.
     */
    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    /**
     * Gets the total quantity of the food item.
     *
     * @return The total quantity of the food item.
     */
    public int getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * Sets the total quantity of the food item.
     *
     * @param totalQuantity The total quantity of the food item to be set.
     */
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
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
