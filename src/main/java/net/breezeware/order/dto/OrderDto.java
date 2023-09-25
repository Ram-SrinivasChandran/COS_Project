package net.breezeware.order.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The OrderDto class represents a data transfer object for creating an order.
 */
public class OrderDto {

    /**
     * The ID of the user placing the order.
     */
    private int userId;

    /**
     * The ID of the order.
     */
    private int orderId;

    /**
     * The list of food items included in the order.
     */
    private List<FoodItemDto> foodItems = new ArrayList<>();

    /**
     * Constructs an OrderDto with the specified user ID, order ID, and list of food items.
     *
     * @param userId    The ID of the user placing the order.
     * @param orderId   The ID of the order.
     * @param foodItems The list of food items included in the order.
     */
    public OrderDto(int userId, int orderId, List<FoodItemDto> foodItems) {
        this.userId = userId;
        this.orderId = orderId;
        this.foodItems = foodItems;
    }

    /**
     * Gets the ID of the user placing the order.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user placing the order.
     *
     * @param userId The user ID to be set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the ID of the order.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the ID of the order.
     *
     * @param orderId The order ID to be set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the list of food items included in the order.
     *
     * @return The list of food items.
     */
    public List<FoodItemDto> getFoodItems() {
        return foodItems;
    }

    /**
     * Sets the list of food items included in the order.
     *
     * @param foodItems The list of food items to be set.
     */
    public void setFoodItems(List<FoodItemDto> foodItems) {
        this.foodItems = foodItems;
    }
}
