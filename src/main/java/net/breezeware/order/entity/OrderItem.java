package net.breezeware.order.entity;

/**
 * The `OrderItem` class represents a list of items included in an order with
 * details such as food item ID, quantity, and cost.
 */
public class OrderItem {

    // Fields (Attributes)
    private int id;          // The unique identifier for the order list item.
    private int orderId;     // The ID of the order to which this item belongs.
    private int foodItemId;  // The ID of the food item included in the order.
    private int quantity;    // The quantity of the food item in the order.
    private double cost;     // The cost of the food item.

    /**
     * Constructs an order list item with details such as order ID, food item ID,
     * quantity, and cost.
     *
     * @param orderId    The ID of the order to which this item belongs.
     * @param foodItemId The ID of the food item included in the order.
     * @param quantity   The quantity of the food item in the order.
     * @param cost       The cost of the food item.
     */
    public OrderItem(int orderId, int foodItemId, int quantity, double cost) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
        this.cost = cost;
    }

    // Getter and Setter methods for the fields...

    /**
     * Gets the unique identifier for the order list item.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the order list item.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the order to which this item belongs.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the ID of the order to which this item belongs.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the ID of the food item included in the order.
     */
    public int getFoodItemId() {
        return foodItemId;
    }

    /**
     * Sets the ID of the food item included in the order.
     */
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    /**
     * Gets the quantity of the food item in the order.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the food item in the order.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the cost of the food item.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the food item.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}
