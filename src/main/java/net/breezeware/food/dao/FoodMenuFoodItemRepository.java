package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class FoodMenuFoodItemRepository {
    Connection connection;
    public static final String TABLE_NAME="food_menu_food_item_map";
    public void addFoodMenuFoodItemMap(List<FoodItem> foodItems,int foodMenuId){
        try {
            connection= DataBaseConnection.getConnection();
            assert connection!=null;
            for (var foodItem:
                 foodItems) {
                PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO "+TABLE_NAME+" (food_menu_id,food_item_id) VALUES (?,?)");
                preparedStatement.setInt(1,foodMenuId);
                preparedStatement.setInt(2,foodItem.getId());
                preparedStatement.execute();
                preparedStatement.close();
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
