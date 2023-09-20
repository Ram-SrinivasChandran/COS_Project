package net.breezeware.food.dto;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.util.List;

public class FoodMenuDto {
    private FoodMenu foodMenu;
    private List<FoodItem> foodItems;

    public FoodMenuDto(FoodMenu foodMenu, List<FoodItem> foodItems) {
        this.foodMenu = foodMenu;
        this.foodItems = foodItems;
    }

    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
