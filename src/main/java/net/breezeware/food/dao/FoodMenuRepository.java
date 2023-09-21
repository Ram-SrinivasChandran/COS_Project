package net.breezeware.food.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.dto.FoodMenuDto;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing food menus in the database.
 */
public class FoodMenuRepository {
    Connection connection;

    /**
     * Name of the database table for food menus.
     */
    public static final String TABLE_NAME = "food_menu";

    /**
     * Adds a new food menu along with associated food items to the database.
     *
     * @param foodMenu The food menu to be added.
     * @return The unique identifier of the added food menu.
     */
    public int addFoodMenu(FoodMenu foodMenu) {
        int foodMenuId = 0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (id,name, type, availabilityOn) VALUES (?,?, ?, ?)");
            preparedStatement.setInt(1, foodMenu.getId());
            preparedStatement.setString(2, foodMenu.getName());
            preparedStatement.setString(3, foodMenu.getType());
            preparedStatement.setString(4, foodMenu.getAvailabilityOn());
            foodMenuId = foodMenu.getId();
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodMenuId;
    }

    /**
     * Retrieves all food menus from the database along with their associated food items.
     */
    public void retrieveFoodMenu() {
        List<FoodMenu> foodMenus = new ArrayList<>();
        List<FoodMenuDto> foodMenuDtoList = new ArrayList<>();
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
            while (resultSet.next()) {
                FoodMenu foodMenu = new FoodMenu(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("availabilityOn")
                );
                foodMenus.add(foodMenu);
            }

            resultSet.close();
            statement.close();

            for (var foodMenu : foodMenus) {
                List<Integer> foodItemIds = new ArrayList<>();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery(
                        "SELECT * FROM food_menu_food_item_map WHERE food_menu_id = " + foodMenu.getId());
                while (resultSet1.next()) {
                    foodItemIds.add(resultSet1.getInt("food_item_id"));
                }
                statement1.close();
                resultSet1.close();

                List<FoodItem> foodItems = new ArrayList<>();
                for (var foodItemId : foodItemIds) {
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery(
                            "SELECT * FROM food_item WHERE id = " + foodItemId);
                    if (resultSet2.next()) {
                        foodItems.add(new FoodItem(
                                resultSet2.getInt("id"),
                                resultSet2.getString("name"),
                                resultSet2.getDouble("cost"),
                                resultSet2.getInt("quantity")
                        ));
                    }
                    resultSet2.close();
                    statement2.close();
                }
                foodMenuDtoList.add(new FoodMenuDto(foodMenu, foodItems));
            }
            connection.close();

            for (var foodMenuDto : foodMenuDtoList) {
                FoodMenu foodMenu = foodMenuDto.getFoodMenu();
                System.out.println("Id : " + foodMenu.getId() +
                        ", Name : " + foodMenu.getName() +
                        ", Type : " + foodMenu.getType() +
                        ", Available On : " + foodMenu.getAvailabilityOn());
                List<FoodItem> foodItems = foodMenuDto.getFoodItems();
                for (var foodItem : foodItems) {
                    System.out.println("     Id : " + foodItem.getId() +
                            ", Name : " + foodItem.getName() +
                            ", Cost : " + foodItem.getCost() +
                            ", Quantity : " + foodItem.getQuantity());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks if a food menu exists in the database.
     *
     * @param foodMenu The food menu to check.
     * @return True if the food menu exists, otherwise false.
     */
    public boolean checkMenu(FoodMenu foodMenu) {
        boolean isMenuAvailable = false;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM " + TABLE_NAME + " WHERE id = " + foodMenu.getId());
            if (resultSet.next()) {
                isMenuAvailable = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isMenuAvailable;
    }

    /**
     * Deletes a food menu and its associated food items from the database.
     *
     * @param foodMenu The food menu to delete.
     * @return True if the food menu was successfully deleted, otherwise false.
     */
    public boolean deleteFoodMenu(FoodMenu foodMenu) {
        boolean isMenuAvailable = true;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM food_menu_food_item_map WHERE food_menu_id = " + foodMenu.getId());
            statement.execute();
            statement.close();

            PreparedStatement statement1 = connection.prepareStatement(
                    "DELETE FROM " + TABLE_NAME + " WHERE id = " + foodMenu.getId());
            statement1.execute();
            statement1.close();

            Statement statement2 = connection.createStatement();
            ResultSet resultSet = statement2.executeQuery(
                    "SELECT * FROM " + TABLE_NAME + " WHERE id = " + foodMenu.getId());
            if (resultSet.next()) {
                isMenuAvailable = false;
            }
            resultSet.close();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isMenuAvailable;
    }
}
