package net.breezeware.order.dto;

public class FoodItemDto {
    private int foodItemId;
    private int foodItemQuantity;
    private double foodCost;
    private int totalQuantity;

    public FoodItemDto(int foodItemId, int foodItemQuantity) {
        this.foodItemId = foodItemId;
        this.foodItemQuantity = foodItemQuantity;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getFoodItemQuantity() {
        return foodItemQuantity;
    }

    public void setFoodItemQuantity(int foodItemQuantity) {
        this.foodItemQuantity = foodItemQuantity;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
