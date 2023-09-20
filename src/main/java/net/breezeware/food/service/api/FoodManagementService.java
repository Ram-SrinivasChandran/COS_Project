package net.breezeware.food.service.api;

import net.breezeware.food.entity.FoodItem;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FoodManagementService {
    int addFoodItem(FoodItem foodItem);
    String viewFoodItem(Integer id) throws SQLException;
    int updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(int id);
}
