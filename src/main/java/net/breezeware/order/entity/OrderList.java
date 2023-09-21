package net.breezeware.order.entity;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.order.entity.Order;

/**
 * Represents an item within an order, containing information about the ordered food item,
 * quantity, and cost.
 */
public class OrderList {
    private int id;            // Unique identifier for the order list item.
    private Order orderId;     // The order to which this item belongs.
    private FoodItem foodItemId; // The food item that is part of this order list item.
    private int quantity;      // The quantity of the food item in the order.
    private double cost;       // The cost associated with this order list item.

    /**
     * Get the unique identifier of the order list item.
     *
     * @return The order list item's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the order list item.
     *
     * @param id The order list item's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the order to which this item belongs.
     *
     * @return The order to which this item belongs.
     */
    public Order getOrderId() {
        return orderId;
    }

    /**
     * Set the order to which this item belongs.
     *
     * @param orderId The order to which this item belongs.
     */
    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the food item that is part of this order list item.
     *
     * @return The food item that is part of this order list item.
     */
    public FoodItem getFoodItemId() {
        return foodItemId;
    }

    /**
     * Set the food item that is part of this order list item.
     *
     * @param foodItemId The food item that is part of this order list item.
     */
    public void setFoodItemId(FoodItem foodItemId) {
        this.foodItemId = foodItemId;
    }

    /**
     * Get the quantity of the food item in the order.
     *
     * @return The quantity of the food item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the food item in the order.
     *
     * @param quantity The quantity of the food item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the cost associated with this order list item.
     *
     * @return The cost of this order list item.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Set the cost associated with this order list item.
     *
     * @param cost The cost of this order list item.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}
