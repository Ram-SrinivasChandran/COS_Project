package net.breezeware.food.service.api;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.sql.SQLException;
import java.util.List;

public interface FoodManagementService {
    int addFoodItem(FoodItem foodItem);
    String retrieveFoodItem(int id) throws SQLException;
    void retrieveFoodItems();
    int updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(int id);
    String addFoodMenu(FoodMenu foodMenu, List<FoodItem> foodItems);
    String addFoodMenuFoodItemMap(List<FoodItem> foodItems,int foodMenuId);
    void retrieveFoodMenu();
}
