package net.breezeware.food.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FoodManagementServiceImplTest {
    FoodManagementService foodManagementService = new FoodManagementServiceImpl();
    @Test
    @Order(1)
    void addFoodItem() {
        FoodItem foodItem = new FoodItem("Idly",10,2);
        assertEquals(1,foodManagementService.addFoodItem(foodItem));
    }
    @Test
    @Order(2)
    void retrieveFoodItem() throws SQLException {
        String actual = foodManagementService.retrieveFoodItem(1);
        assertEquals("Idly",actual);
    }
    @Test
    @Order(3)
    void retrieveFoodItems(){
        foodManagementService.retrieveFoodItems();
    }
    @Test
    @Order(4)
    void updateFoodItem(){
        FoodItem foodItem = new FoodItem(1,"Dosa",20,5);
        assertEquals(1,foodManagementService.updateFoodItem(foodItem));
    }
    @Test
    @Order(5)
    void deleteFoodItem(){
        foodManagementService.deleteFoodItem(1);
    }
    @Test
    @Order(6)
    void addFoodMenu(){
    List<FoodItem> foodItems=new ArrayList<>();
    foodItems.add(new FoodItem("Idly",10,20));
    foodItems.add(new FoodItem("Dosa",20,20));
    foodItems.add(new FoodItem("Poori",25,30));
    FoodMenu foodMenu=new FoodMenu("Breakfast","Veg","Monday");
    assertEquals("Breakfast",foodManagementService.addFoodMenu(foodMenu,foodItems));
    }
}