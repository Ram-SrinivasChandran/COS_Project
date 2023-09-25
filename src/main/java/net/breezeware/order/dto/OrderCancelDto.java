package net.breezeware.order.dto;

/**
 * The OrderCancelDto class represents a data transfer object for canceling a food item in an order.
 */
public class OrderCancelDto {

    /**
     * The ID of the food item to be canceled.
     */
    private int foodItemId;

    /**
     * The quantity of the food item to be canceled.
     */
    private int quantity;

    /**
     * Constructs an OrderCancelDto with the specified food item ID and quantity.
     *
     * @param foodItemId The ID of the food item to be canceled.
     * @param quantity   The quantity of the food item to be canceled.
     */
    public OrderCancelDto(int foodItemId, int quantity) {
        this.foodItemId = foodItemId;
        this.quantity = quantity;
    }

    /**
     * Gets the ID of the food item to be canceled.
     *
     * @return The food item ID.
     */
    public int getFoodItemId() {
        return foodItemId;
    }

    /**
     * Sets the ID of the food item to be canceled.
     *
     * @param foodItemId The food item ID to be set.
     */
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    /**
     * Gets the quantity of the food item to be canceled.
     *
     * @return The quantity of the food item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the food item to be canceled.
     *
     * @param quantity The quantity of the food item to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
