package net.breezeware.food.service.impl;

import net.breezeware.food.dto.FoodMenuDto;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.enumeration.Days;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FoodManagementServiceImplTest {
    FoodManagementService foodManagementService = new FoodManagementServiceImpl();
    /**
     * Test the 'addFoodItem' method.
     */
    @Test
    @Order(1)
    void addFoodItem() {
        FoodItem foodItem = new FoodItem("Idly",10,2);
        assertEquals(1,foodManagementService.addFoodItem(foodItem));
    }
    /**
     * Test the 'retrieveFoodItem' method.
     *
     * @throws SQLException if there is an issue with database operations.
     */
    @Test
    @Order(2)
    void retrieveFoodItem() throws SQLException {
        String actual = foodManagementService.retrieveFoodItem(1);
        assertEquals("Idly",actual);
    }
    /**
     * Test the 'retrieveFoodItems' method.
     */
    @Test
    @Order(3)
    void retrieveFoodItems(){
        foodManagementService.retrieveFoodItems();
    }
    /**
     * Test the 'updateFoodItem' method.
     */
    @Test
    @Order(4)
    void updateFoodItem(){
        FoodItem foodItem = new FoodItem(1,"Dosa",20,5);
        assertEquals(1,foodManagementService.updateFoodItem(foodItem));
    }
    /**
     * Test the 'deleteFoodItem' method.
     */
    @Test
    @Order(5)
    void deleteFoodItem(){
        foodManagementService.deleteFoodItem(1);
    }
    /**
     * Test the 'addFoodMenu' method.
     */
    @Test
    @Order(6)
    void addFoodMenu(){
        // Test adding a breakfast menu
//        List<FoodItem> foodItems=new ArrayList<>();
//        foodItems.add(new FoodItem("Idly",10,20));
//        foodItems.add(new FoodItem("Dosa",20,20));
//        foodItems.add(new FoodItem("Parotta",25,30));
//        String days= String.valueOf(Days.Sunday);
//        FoodMenu foodMenu=new FoodMenu(7,"Breakfast","Veg",days);
//        assertEquals(days,foodManagementService.addFoodMenu(new FoodMenuDto(foodMenu,foodItems)));
        // Test adding a lunch menu
//        List<FoodItem> foodItems1=new ArrayList<>();
//        foodItems1.add(new FoodItem("Parotta",10,20));
//        foodItems1.add(new FoodItem("Briyani",50,30));
//        String days= String.valueOf(Days.Sunday);
//        FoodMenu foodMenu1=new FoodMenu(14,"Lunch","N-Veg",days);
//        assertEquals(days,foodManagementService.addFoodMenu(new FoodMenuDto(foodMenu1,foodItems1)));
//        // Test adding a dinner menu
        List<FoodItem> foodItems2=new ArrayList<>();
        foodItems2.add(new FoodItem("Briyani",50,20));
        foodItems2.add(new FoodItem("Parotta",10,30));
        String days= String.valueOf(Days.SUNDAY);
        FoodMenu foodMenu2=new FoodMenu(21,"Dinner","N-Veg",days);
        assertEquals(days,foodManagementService.addFoodMenu(new FoodMenuDto(foodMenu2,foodItems2)));
    }
    /**
     * Test the 'retrieveFoodMenu' method.
     */
    @Test
    @Order(7)
    void retrieveFoodMenu(){
        foodManagementService.retrieveFoodMenu();
    }
    /**
     * Test the 'updateMenu' method.
     */
    @Test
    @Order(8)
    void updateMenu(){
        List<FoodItem> foodItems=new ArrayList<>();
        foodItems.add(new FoodItem(1,"Idly",20,200));
        foodItems.add(new FoodItem(2,"Dosa",30,100));
        FoodMenu foodMenu=new FoodMenu(1,"Breakfast","Veg","Monday");
        FoodMenuDto foodMenuDto=new FoodMenuDto(foodMenu,foodItems);
        foodManagementService.updateFoodMenu(foodMenuDto);
    }
    /**
     * Test the 'deleteFoodMenu' method.
     */
    @Test
    @Order(9)
    void deleteFoodMenu(){
        assertTrue(foodManagementService.deleteFoodMenu(new FoodMenu(1,"Breakfast","Veg","Monday")));
    }
}