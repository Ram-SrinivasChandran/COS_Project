package net.breezeware.food.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.Test;
class FoodManagementServiceImplTest {

    FoodManagementService foodManagementService = new FoodManagementServiceImpl();

    @Test
    void addFoodItem() {
        FoodItem foodItem = new FoodItem(1,"idly",10,2);
        foodManagementService.addFoodItem(foodItem);
    }
}