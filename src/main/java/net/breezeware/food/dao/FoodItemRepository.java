package net.breezeware.food.dao;

import net.breezeware.Main;
import net.breezeware.food.entity.FoodItem;

import java.sql.Connection;
import java.sql.Statement;

public class FoodItemRepository {
    public static final String TABLE_NAME = "food_item";

    public void addFoodItem(FoodItem foodItem) {
        try {
            Connection connection = Main.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO " + TABLE_NAME + " (id,name,cost,quantity) VALUES (" +
                    foodItem.getId() + " , " + "'" + foodItem.getName() + "'" + " , " + foodItem.getCost() + " , " + foodItem.getQuantity() + " )");
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
