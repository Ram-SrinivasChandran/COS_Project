package net.breezeware.food.service.impl;
import net.breezeware.food.dao.FoodItemRepository;
import net.breezeware.food.dao.FoodMenuFoodItemRepository;
import net.breezeware.food.dao.FoodMenuRepository;
import net.breezeware.food.dto.FoodMenuDto;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.service.api.FoodManagementService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FoodManagementServiceImpl implements FoodManagementService {
    FoodItemRepository foodItemRepository=new FoodItemRepository();
    FoodMenuFoodItemRepository foodMenuFoodItemRepository=new FoodMenuFoodItemRepository();
    FoodMenuRepository foodMenuRepository =new FoodMenuRepository();
    public int addFoodItem(FoodItem foodItem){
        return foodItemRepository.addFoodItem(foodItem);
    }
    public String retrieveFoodItem(int id) throws SQLException {
        ResultSet resultSet = foodItemRepository.retrieveFoodItem(id);
        String name = resultSet.getString("name");
        resultSet.close();
        return name;
    }
    public void retrieveFoodItems(){
        foodItemRepository.retrieveFoodItems();
    }
    public int updateFoodItem(FoodItem foodItem){
        System.out.println("The Food Name is Updated.");
        return foodItemRepository.updateFoodItem(foodItem);
    }
    public void deleteFoodItem(int id){
        System.out.println("The Food Item in the given id is Deleted.");
        foodItemRepository.deleteFoodItem(id);
    }
    public String addFoodMenu(FoodMenu foodMenu, List<FoodItem> foodItems){
        String foodMenuName=null;
        int foodMenuId = foodMenuRepository.addFoodMenu(foodMenu, foodItems);
        if(foodMenuId!=0){
            System.out.println("Food Menu is Added.");
            for (var foodItem:
                    foodItems) {
                addFoodItem(foodItem);
            }
            foodMenuName=addFoodMenuFoodItemMap(foodItems,foodMenuId);
        }
        return foodMenuName;
    }
    public String addFoodMenuFoodItemMap(List<FoodItem> foodItems,int foodMenuId){
        return foodMenuFoodItemRepository.addFoodMenuFoodItemMap(foodItems, foodMenuId);
    }
    public void retrieveFoodMenu(){
        foodMenuRepository.retrieveFoodMenu();
    }
    public void updateFoodMenu(FoodMenuDto foodMenuDto){
        if(foodMenuRepository.checkMenu(foodMenuDto.getFoodMenu())){
            List<FoodItem> foodItems = foodMenuDto.getFoodItems();
            for (var foodItem:
                    foodItems) {
                    updateFoodItem(foodItem);
            }
        }else{
            System.out.println("There is no Menu with the given Food Item Detail");
        }
    }
}
