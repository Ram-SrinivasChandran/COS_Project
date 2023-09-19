package net.breezeware.food.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FoodManagementServiceImplTest {
    FoodManagementService foodManagementService = new FoodManagementServiceImpl();
    @Test
    @Order(1)
    void addFoodItem() {
        FoodItem foodItem = new FoodItem(1,"idly",10,2);
        assertEquals(1,foodManagementService.addFoodItem(foodItem));
    }
    @Test
    @Order(2)
    void viewFoodItem() throws SQLException {
        ResultSet expected = foodManagementService.viewFoodItem(1);
        assertEquals(expected.getString("name"),"idly");
    }
    @Test
    @Order(3)
    void updateFoodItem(){
        FoodItem foodItem = new FoodItem(1,"dosa",20,5);
        assertEquals(1,foodManagementService.updateFoodItem(foodItem));
    }
    @Test
    @Order(4)

    void deleteFoodItem(){
        foodManagementService.deleteFoodItem(1);
    }
}