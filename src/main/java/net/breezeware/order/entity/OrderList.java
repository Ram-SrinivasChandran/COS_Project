package net.breezeware.order.entity;

public class OrderList {
    private int id;
    private int orderId;
    private int foodItemId;
    private int quantity;
    private double cost;

    public OrderList(int orderId, int foodItemId, int quantity, double cost) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
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
