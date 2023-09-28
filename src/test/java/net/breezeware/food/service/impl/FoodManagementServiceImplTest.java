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

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FoodManagementServiceImplTest {
    FoodManagementService foodManagementService = new FoodManagementServiceImpl();
    /**
     * Test the 'addFoodItem' method.
     */
    @Test
    @Order(1)
    void testAddFoodItem() {
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
    void testRetrieveFoodItem() throws SQLException {
        String actual = foodManagementService.retrieveFoodItem(1);
        assertEquals("Idly",actual);
    }
    /**
     * Test the 'retrieveFoodItems' method.
     */
    @Test
    @Order(3)
    void testRetrieveFoodItems(){
        List<FoodItem> foodItems=foodManagementService.retrieveFoodItems();
        for (var foodItem:
             foodItems) {
            System.out.println("Id: " + foodItem.getId() +
                    ", Name: " + foodItem.getName() +
                    ", Cost: " + foodItem.getCost() +
                    ", Total Quantity: " + foodItem.getQuantity());
        }
        assertEquals(1,foodItems.size());
    }
    /**
     * Test the 'updateFoodItem' method.
     */
    @Test
    @Order(4)
    void testUpdateFoodItem(){
        FoodItem foodItem = new FoodItem(1,"Dosa",20,5);
        assertEquals(1,foodManagementService.updateFoodItem(foodItem));
    }
    /**
     * Test the 'deleteFoodItem' method.
     */
    @Test
    @Order(5)
    void testDeleteFoodItem(){
        assertEquals(1,foodManagementService.deleteFoodItem(1));
    }
    /**
     * Test the 'addFoodMenu' method.
     */
    @Test
    @Order(6)
    void testAddFoodMenu(){
//         Test adding a breakfast menu
        List<FoodItem> breakfast=new ArrayList<>();
        breakfast.add(new FoodItem("Idly",10,20));
        breakfast.add(new FoodItem("Dosa",20,20));
        breakfast.add(new FoodItem("Pongal",25,30));
        String days= String.valueOf(Days.TUESDAY);
        FoodMenu foodMenu=new FoodMenu(4,"Breakfast","Veg",days);
        assertEquals(days,foodManagementService.addFoodMenu(new FoodMenuDto(foodMenu,breakfast)));
//         Test adding a lunch menu
        List<FoodItem> lunch=new ArrayList<>();
        lunch.add(new FoodItem("Parotta",10,20));
        lunch.add(new FoodItem("Rice",50,30));
        FoodMenu foodMenu1=new FoodMenu(5,"Lunch","Veg",days);
        assertEquals(days,foodManagementService.addFoodMenu(new FoodMenuDto(foodMenu1,lunch)));
//         Test adding a dinner menu
        List<FoodItem> dinner=new ArrayList<>();
        dinner.add(new FoodItem("Egg-Rice",50,20));
        dinner.add(new FoodItem("Parotta",10,30));
        FoodMenu foodMenu2=new FoodMenu(6,"Dinner","N-Veg",days);
        assertEquals(days,foodManagementService.addFoodMenu(new FoodMenuDto(foodMenu2,dinner)));
    }
    /**
     * Test the 'retrieveFoodMenu' method.
     */
    @Test
    @Order(7)
    void testRetrieveFoodMenu(){
        List<FoodMenuDto> foodMenuDtoList=foodManagementService.retrieveFoodMenu();
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
        assertEquals(6,foodMenuDtoList.size());
    }
    /**
     * Test the 'updateMenu' method.
     */
    @Test
    @Order(8)
    void testUpdateMenu(){
        List<FoodItem> foodItems=new ArrayList<>();
        foodItems.add(new FoodItem(1,"Idly",20,200));
        foodItems.add(new FoodItem(2,"Dosa",30,100));
        String days= String.valueOf(Days.MONDAY);
        FoodMenu foodMenu=new FoodMenu(1);
        FoodMenuDto foodMenuDto=new FoodMenuDto(foodMenu,foodItems);
        assertEquals(1,foodManagementService.updateFoodMenu(foodMenuDto));
    }
    /**
     * Test the 'deleteFoodMenu' method.
     */
    @Test
    @Order(9)
    void testDeleteFoodMenu(){
        assertTrue(foodManagementService.deleteFoodMenu(1));
    }
}