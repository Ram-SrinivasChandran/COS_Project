package net.breezeware.order.dto;

public class OrderCancelDto {
    int foodItemId;
    int quantity;

    public OrderCancelDto(int foodItemId, int quantity) {
        this.foodItemId = foodItemId;
        this.quantity = quantity;
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
}
