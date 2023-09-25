package net.breezeware.order.dto;

public class DisplayFoodItemDto {
    private FoodItemDto foodItemDto;
    private String foodItemName;

    public DisplayFoodItemDto(FoodItemDto foodItemDto, String foodItemName) {
        this.foodItemDto = foodItemDto;
        this.foodItemName = foodItemName;
    }

    public FoodItemDto getFoodItemDto() {
        return foodItemDto;
    }

    public void setFoodItemDto(FoodItemDto foodItemDto) {
        this.foodItemDto = foodItemDto;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }
}
