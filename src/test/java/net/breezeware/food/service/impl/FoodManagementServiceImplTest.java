package net.breezeware.food.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    @Test
    @Order(5)
    void addFoodMenu(){
    List<FoodItem> foodItems=new ArrayList<>();
    foodItems.add(new FoodItem(1,"Idly",10,20));
    foodItems.add(new FoodItem(2,"Dosa",20,20));
    foodItems.add(new FoodItem(3,"Poori",25,30));
    FoodMenu foodMenu=new FoodMenu(1,"Breakfast","Veg","Monday");
    assertEquals(1,foodManagementService.addFoodMenu(foodMenu,foodItems));
    }
}