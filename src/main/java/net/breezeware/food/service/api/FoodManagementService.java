package net.breezeware.food.service.api;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.sql.SQLException;
import java.util.List;

public interface FoodManagementService {
    int addFoodItem(FoodItem foodItem);
    String viewFoodItem(Integer id) throws SQLException;
    int updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(int id);
    int addFoodMenu(FoodMenu foodMenu, List<FoodItem> foodItems);
    void addFoodMenuFoodItemMap(List<FoodItem> foodItems,int foodMenuId);
}
