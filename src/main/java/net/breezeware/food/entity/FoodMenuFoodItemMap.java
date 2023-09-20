package net.breezeware.food.entity;

public class FoodMenuFoodItemMap {
    private int id;
    private FoodMenu foodMenuId;
    private FoodItem foodItemId;

    public FoodMenuFoodItemMap(int id, FoodMenu foodMenuId, FoodItem foodItemId) {
        this.id = id;
        this.foodMenuId = foodMenuId;
        this.foodItemId = foodItemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodMenu getFoodMenuId() {
        return foodMenuId;
    }

    public void setFoodMenuId(FoodMenu foodMenuId) {
        this.foodMenuId = foodMenuId;
    }

    public FoodItem getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(FoodItem foodItemId) {
        this.foodItemId = foodItemId;
    }
}
