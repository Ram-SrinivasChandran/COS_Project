package net.breezeware.food.service.impl;

import net.breezeware.food.dto.FoodMenuDto;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
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
    List<FoodItem> foodItems1=new ArrayList<>();
    foodItems1.add(new FoodItem("Idly",10,20));
    foodItems1.add(new FoodItem("Dosa",20,20));
    foodItems1.add(new FoodItem("Rice",25,30));
    FoodMenu foodMenu1=new FoodMenu("Lunch","Veg","Monday");
    assertEquals("Lunch",foodManagementService.addFoodMenu(foodMenu1,foodItems1));
    List<FoodItem> foodItems2=new ArrayList<>();
    foodItems2.add(new FoodItem("Idly",10,20));
    foodItems2.add(new FoodItem("Dosa",20,20));
    foodItems2.add(new FoodItem("Parotta",25,30));
    FoodMenu foodMenu2=new FoodMenu("Dinner","Veg","Monday");
    assertEquals("Dinner",foodManagementService.addFoodMenu(foodMenu2,foodItems2));
    }
    @Test
    @Order(7)
    void retrieveFoodMenu(){
        foodManagementService.retrieveFoodMenu();
    }
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
    @Test
    @Order(9)
    void deleteFoodMenu(){
        assertTrue(foodManagementService.deleteFoodMenu(new FoodMenu(1,"Breakfast","Veg","Monday")));
    }
}