package net.breezeware.order.dto;

public class OrderUpdateDto {
    private int orderId;
    private int foodItemId;
    private int newQuantity;
    private int oldQuantity;
    private double cost;

    public OrderUpdateDto(int orderId, int foodItemId, int newQuantity) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.newQuantity = newQuantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderUpdateDto(int foodItemId, int newQuantity) {
        this.foodItemId = foodItemId;
        this.newQuantity = newQuantity;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }

    public int getOldQuantity() {
        return oldQuantity;
    }

    public void setOldQuantity(int oldQuantity) {
        this.oldQuantity = oldQuantity;
    }
}
