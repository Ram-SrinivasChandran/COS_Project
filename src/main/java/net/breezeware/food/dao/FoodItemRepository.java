package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;

import java.sql.*;

public class FoodItemRepository {
    public static final String TABLE_NAME = "food_item";
    Connection connection;

    public int addFoodItem(FoodItem foodItem) {
        int recordsInserted=0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement=connection.prepareStatement("INSERT INTO "+TABLE_NAME+" VALUES (?,?,?,?)");
            statement.setInt(1,foodItem.getId());
            statement.setString(2,foodItem.getName());
            statement.setDouble(3,foodItem.getCost());
            statement.setInt(4,foodItem.getQuantity());
            recordsInserted = statement.executeUpdate();
            System.out.println("The Food Item is Added." );
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recordsInserted;
    }

    public ResultSet viewFoodItem(Integer id) {
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id") + " Name : " + resultSet.getString("name") + " Cost :" + resultSet.getDouble("cost") + " Quantity : " + resultSet.getInt("quantity"));
                return resultSet;
            } else {
                System.out.println("No Food Item is Available in this id : " + id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int updateFoodItem(FoodItem foodItem) {
        int recordsChanged=0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement=connection.prepareStatement("UPDATE "+TABLE_NAME+" SET name=?,cost=?,quantity=? WHERE id="+foodItem.getId());
            statement.setString(1,foodItem.getName());
            statement.setDouble(2,foodItem.getCost());
            statement.setInt(3,foodItem.getQuantity());
            recordsChanged = statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return recordsChanged;
    }

    public void deleteFoodItem(int id) {
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement=connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id="+id);
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
