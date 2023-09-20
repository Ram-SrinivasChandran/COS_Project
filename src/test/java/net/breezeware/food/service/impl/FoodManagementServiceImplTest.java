package net.breezeware.food.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        String actual = foodManagementService.viewFoodItem(1);
        assertEquals("idly",actual);
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