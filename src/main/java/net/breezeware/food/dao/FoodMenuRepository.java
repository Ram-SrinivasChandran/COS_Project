package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.service.api.FoodManagementService;
import net.breezeware.food.service.impl.FoodManagementServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class FoodMenuRepository {
    Connection connection;
    public static final String TABLE_NAME="food_menu";
    public int addFoodMenu(FoodMenu foodMenu, List<FoodItem> foodItems){
        int foodMenuId=0;
        try{
            connection= DataBaseConnection.getConnection();
            assert connection!=null;
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO "+TABLE_NAME+" (name,type,availabilityOn) VALUES (?,?,?)");
            preparedStatement.setString(1,foodMenu.getName());
            preparedStatement.setString(2,foodMenu.getType());
            preparedStatement.setString(3, foodMenu.getAvailabilityOn());
            preparedStatement.execute();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+TABLE_NAME+" WHERE name= '"+foodMenu.getName()+"'");
            if(resultSet.next()){
                foodMenuId=resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
            preparedStatement.close();
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return foodMenuId;
    }
}
