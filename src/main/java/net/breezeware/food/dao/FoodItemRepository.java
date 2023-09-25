package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing food items in the database.
 */
public class FoodItemRepository {
    public static final String TABLE_NAME = "food_item";
    Connection connection;

    /**
     * Adds a new food item to the database.
     *
     * @param foodItem The food item to be added.
     * @return The number of records inserted (0 if the item already exists).
     */
    public int addFoodItem(FoodItem foodItem) {
        int recordsInserted = 0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (name, cost, quantity) VALUES (?, ?, ?)");
            statement.setString(1, foodItem.getName());
            statement.setDouble(2, foodItem.getCost());
            statement.setInt(3, foodItem.getQuantity());
            recordsInserted = statement.executeUpdate();
            System.out.println("The Food Item is Added.");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Food Item is Already Exists");
        }
        return recordsInserted;
    }

    /**
     * Retrieves a food item by its unique identifier (id) from the database.
     *
     * @param id The unique identifier of the food item.
     * @return A ResultSet containing the food item's details, or null if not found.
     */
    public ResultSet retrieveFoodItem(int id) {
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id") +
                        " Name: " + resultSet.getString("name") +
                        " Cost: " + resultSet.getDouble("cost") +
                        " Quantity: " + resultSet.getInt("quantity"));
                return resultSet;
            } else {
                System.out.println("No Food Item is Available in this id: " + id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves all food items from the database and prints their details.
     */
    public List<FoodItem> retrieveFoodItems() {
        List<FoodItem> foodItems=new ArrayList<>();
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name=resultSet.getString("name");
                double cost=resultSet.getDouble("cost");
                int quantity=resultSet.getInt("quantity");
                foodItems.add(new FoodItem(id,name,cost,quantity));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return foodItems;
    }

    /**
     * Updates an existing food item in the database.
     *
     * @param foodItem The updated food item.
     * @return The number of records changed (0 if the item does not exist).
     */
    public int updateFoodItem(FoodItem foodItem) {
        int recordsChanged = 0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE " + TABLE_NAME + " SET name=?, cost=?, quantity=? WHERE id=" + foodItem.getId());
            statement.setString(1, foodItem.getName());
            statement.setDouble(2, foodItem.getCost());
            statement.setInt(3, foodItem.getQuantity());
            recordsChanged = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return recordsChanged;
    }

    /**
     * Deletes a food item from the database by its unique identifier (id).
     *
     * @param id The unique identifier of the food item to delete.
     */
    public int deleteFoodItem(int id) {
        int recordsChanged=0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM " + TABLE_NAME + " WHERE id=" + id);
            recordsChanged = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return recordsChanged;
    }
}
