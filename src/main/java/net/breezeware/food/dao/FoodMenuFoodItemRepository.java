package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class FoodMenuFoodItemRepository {
    Connection connection;
    public static final String TABLE_NAME="food_menu_food_item_map";
    public String addFoodMenuFoodItemMap(List<FoodItem> foodItems,int foodMenuId){
        String foodMenuName=null;
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
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM food_menu WHERE id="+foodMenuId);
            if(resultSet.next()){
                foodMenuName=resultSet.getString("name");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return foodMenuName;
    }
}
