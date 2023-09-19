package net.breezeware.food.service.impl;
import net.breezeware.food.dao.FoodItemRepository;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;

import java.sql.ResultSet;

public class FoodManagementServiceImpl implements FoodManagementService {
    FoodItemRepository foodItemRepository=new FoodItemRepository();
    public int addFoodItem(FoodItem foodItem){
        return foodItemRepository.addFoodItem(foodItem);
    }
    public ResultSet viewFoodItem(Integer id){
        return foodItemRepository.viewFoodItem(id);
    }
    public int updateFoodItem(FoodItem foodItem){
        return foodItemRepository.updateFoodItem(foodItem);
    }
    public void deleteFoodItem(int id){
         foodItemRepository.deleteFoodItem(id);
    }
}
