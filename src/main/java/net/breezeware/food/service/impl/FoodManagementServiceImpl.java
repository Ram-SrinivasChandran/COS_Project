package net.breezeware.food.service.impl;
import net.breezeware.food.dao.FoodItemRepository;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;

public class FoodManagementServiceImpl implements FoodManagementService {
    FoodItemRepository foodItemRepository=new FoodItemRepository();
    public void addFoodItem(FoodItem foodItem){
        foodItemRepository.addFoodItem(foodItem);
    }
}
