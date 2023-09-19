package net.breezeware.food.service.api;

import net.breezeware.food.entity.FoodItem;

import java.sql.ResultSet;

public interface FoodManagementService {
    int addFoodItem(FoodItem foodItem);
    ResultSet viewFoodItem(Integer id);
    int updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(int id);
}
