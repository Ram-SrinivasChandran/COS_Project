package net.breezeware.order;

import net.breezeware.food.entity.FoodItem;

public class OrderList {
    private int id;
    private Order orderId;
    private FoodItem foodItemId;
    private int quantity;
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public FoodItem getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(FoodItem foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
