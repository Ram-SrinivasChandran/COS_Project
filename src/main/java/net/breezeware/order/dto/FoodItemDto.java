package net.breezeware.order.dto;

public class FoodItemDto {
    int foodItemId;
    int foodItemQuantity;

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
}
