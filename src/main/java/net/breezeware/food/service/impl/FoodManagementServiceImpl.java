package net.breezeware.food.service.impl;
import net.breezeware.food.dao.FoodItemRepository;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodManagementServiceImpl implements FoodManagementService {
    FoodItemRepository foodItemRepository=new FoodItemRepository();
    public int addFoodItem(FoodItem foodItem){
        return foodItemRepository.addFoodItem(foodItem);
    }
    public String viewFoodItem(Integer id) throws SQLException {
        ResultSet resultSet = foodItemRepository.viewFoodItem(id);
        String name = resultSet.getString("name");
        resultSet.close();
        return name;
    }
    public int updateFoodItem(FoodItem foodItem){
        System.out.println("The Food Name is Updated.");
        return foodItemRepository.updateFoodItem(foodItem);
    }
    public void deleteFoodItem(int id){
        System.out.println("The Food Item in the given id is Deleted.");
         foodItemRepository.deleteFoodItem(id);
    }
}
