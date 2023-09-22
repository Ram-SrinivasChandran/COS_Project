package net.breezeware.order.dto;

public class OrderViewResponseDto {
    private int foodItemId;
    private int foodItemQuantity;
    private double foodItemCost;

    public OrderViewResponseDto(int foodItemId, int foodItemQuantity, double foodItemCost) {
        this.foodItemId = foodItemId;
        this.foodItemQuantity = foodItemQuantity;
        this.foodItemCost = foodItemCost;
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

    public double getFoodItemCost() {
        return foodItemCost;
    }

    public void setFoodItemCost(double foodItemCost) {
        this.foodItemCost = foodItemCost;
    }
}
