package net.breezeware.order.dto;

/**
 * The OrderUpdateDto class represents a data transfer object for updating order details.
 */
public class OrderUpdateDto {

    /**
     * The ID of the order to be updated.
     */
    private int orderId;

    /**
     * The ID of the food item to be updated.
     */
    private int foodItemId;

    /**
     * The new quantity of the food item in the order.
     */
    private int newQuantity;

    /**
     * The old quantity of the food item in the order (used for reference).
     */
    private int oldQuantity;

    /**
     * The cost associated with the order update.
     */
    private double cost;

    /**
     * Constructs an OrderUpdateDto with the specified order ID, food item ID, and new quantity.
     *
     * @param orderId     The ID of the order to be updated.
     * @param foodItemId  The ID of the food item to be updated.
     * @param newQuantity The new quantity of the food item in the order.
     */
    public OrderUpdateDto(int orderId, int foodItemId, int newQuantity) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.newQuantity = newQuantity;
    }

    /**
     * Constructs an OrderUpdateDto with the specified food item ID and new quantity.
     *
     * @param foodItemId  The ID of the food item to be updated.
     * @param newQuantity The new quantity of the food item in the order.
     */
    public OrderUpdateDto(int foodItemId, int newQuantity) {
        this.foodItemId = foodItemId;
        this.newQuantity = newQuantity;
    }

    /**
     * Gets the cost associated with the order update.
     *
     * @return The order update cost.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost associated with the order update.
     *
     * @param cost The order update cost to be set.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets the ID of the order to be updated.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the ID of the order to be updated.
     *
     * @param orderId The order ID to be set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the ID of the food item to be updated.
     *
     * @return The food item ID.
     */
    public int getFoodItemId() {
        return foodItemId;
    }

    /**
     * Sets the ID of the food item to be updated.
     *
     * @param foodItemId The food item ID to be set.
     */
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    /**
     * Gets the new quantity of the food item in the order.
     *
     * @return The new food item quantity.
     */
    public int getNewQuantity() {
        return newQuantity;
    }

    /**
     * Sets the new quantity of the food item in the order.
     *
     * @param newQuantity The new food item quantity to be set.
     */
    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }

    /**
     * Gets the old quantity of the food item in the order (used for reference).
     *
     * @return The old food item quantity.
     */
    public int getOldQuantity() {
        return oldQuantity;
    }

    /**
     * Sets the old quantity of the food item in the order (used for reference).
     *
     * @param oldQuantity The old food item quantity to be set.
     */
    public void setOldQuantity(int oldQuantity) {
        this.oldQuantity = oldQuantity;
    }
}
