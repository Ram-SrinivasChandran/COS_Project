package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Repository class for managing the mapping between food menus and food items in the database.
 */
public class FoodMenuFoodItemRepository {
    Connection connection;

    /**
     * Name of the database table for mapping between food menus and food items.
     */
    public static final String TABLE_NAME = "food_menu_food_item_map";

    /**
     * Adds mappings between a list of food items and a food menu in the database.
     *
     * @param foodItems  The list of food items to be associated with the food menu.
     * @param foodMenuId The unique identifier of the food menu.
     * @return The name of the food menu to which the items were mapped.
     */
    public String addFoodMenuFoodItemMap(List<FoodItem> foodItems, int foodMenuId) {
        String foodMenuName = null;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            for (var foodItem : foodItems) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM food_item WHERE name = '" + foodItem.getName() + "'");
                int foodItemId = 0;
                if (resultSet.next()) {
                    foodItemId = resultSet.getInt("id");
                }
                resultSet.close();
                statement.close();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO " + TABLE_NAME + " (food_menu_id, food_item_id) VALUES (?, ?)");
                preparedStatement.setInt(1, foodMenuId);
                preparedStatement.setInt(2, foodItemId);
                preparedStatement.execute();
                preparedStatement.close();
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM food_menu WHERE id = " + foodMenuId);
            if (resultSet.next()) {
                foodMenuName = resultSet.getString("name");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodMenuName;
    }
}
