package net.breezeware.order.dto;

/**
 * The OrderViewResponseDto class represents a data transfer object for displaying order details.
 */
public class OrderViewResponseDto {

    /**
     * The ID of the food item in the order.
     */
    private int foodItemId;

    /**
     * The quantity of the food item in the order.
     */
    private int foodItemQuantity;

    /**
     * The cost of the food item in the order.
     */
    private double foodItemCost;

    /**
     * Constructs an OrderViewResponseDto with the specified food item ID, quantity, and cost.
     *
     * @param foodItemId       The ID of the food item in the order.
     * @param foodItemQuantity The quantity of the food item in the order.
     * @param foodItemCost     The cost of the food item in the order.
     */
    public OrderViewResponseDto(int foodItemId, int foodItemQuantity, double foodItemCost) {
        this.foodItemId = foodItemId;
        this.foodItemQuantity = foodItemQuantity;
        this.foodItemCost = foodItemCost;
    }

    /**
     * Gets the ID of the food item in the order.
     *
     * @return The food item ID.
     */
    public int getFoodItemId() {
        return foodItemId;
    }

    /**
     * Sets the ID of the food item in the order.
     *
     * @param foodItemId The food item ID to be set.
     */
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    /**
     * Gets the quantity of the food item in the order.
     *
     * @return The food item quantity.
     */
    public int getFoodItemQuantity() {
        return foodItemQuantity;
    }

    /**
     * Sets the quantity of the food item in the order.
     *
     * @param foodItemQuantity The food item quantity to be set.
     */
    public void setFoodItemQuantity(int foodItemQuantity) {
        this.foodItemQuantity = foodItemQuantity;
    }

    /**
     * Gets the cost of the food item in the order.
     *
     * @return The food item cost.
     */
    public double getFoodItemCost() {
        return foodItemCost;
    }

    /**
     * Sets the cost of the food item in the order.
     *
     * @param foodItemCost The food item cost to be set.
     */
    public void setFoodItemCost(double foodItemCost) {
        this.foodItemCost = foodItemCost;
    }
}
