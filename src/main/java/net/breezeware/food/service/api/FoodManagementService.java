package net.breezeware.food.service.api;

import net.breezeware.food.dto.FoodMenuDto;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;

import java.sql.SQLException;
import java.util.List;

/**
 * An interface for managing food-related operations such as adding food items,
 * retrieving food items, updating food items, and managing food menus.
 */
public interface FoodManagementService {

    /**
     * Add a new food item to the system.
     *
     * @param foodItem The food item object to be added.
     * @return An integer indicating the result of the operation with the recordsChanged count.
     */
    int addFoodItem(FoodItem foodItem);

    /**
     * Retrieve the name of a food item by its ID.
     *
     * @param id The ID of the food item to retrieve.
     * @return The name of the retrieved food item.
     * @throws SQLException if there is an issue with database operations.
     */
    String retrieveFoodItem(int id) throws SQLException;

    /**
     * Retrieve a list of food items.
     */
    List<FoodItem> retrieveFoodItems();

    /**
     * Update a food item's information.
     *
     * @param foodItem The updated food item object.
     * @return An integer indicating the result of the operation with the recordsChanged count.
     */
    int updateFoodItem(FoodItem foodItem);

    /**
     * Delete a food item by its ID.
     *
     * @param id The ID of the food item to delete.
     */
    int deleteFoodItem(int id);

    /**
     * Add a new food menu along with its associated food items.
     *
     * @param foodMenuDto  The food menu DTO contains the food menu object and list of foodItems to be added.
     * @return The name of the added food menu.
     */
    String addFoodMenu(FoodMenuDto foodMenuDto);

    /**
     * Add mappings between food items and a food menu.
     *
     * @param foodItems   The list of food items to be associated with the menu.
     * @param foodMenuId  The ID of the food menu.
     * @return The name of the added food menu.
     */
    String addFoodMenuFoodItemMap(List<FoodItem> foodItems, int foodMenuId);

    /**
     * Retrieve a list of food menus.
     */
    List<FoodMenuDto> retrieveFoodMenu();

    /**
     * Update a food menu and its associated food items.
     *
     * @param foodMenuDto The DTO containing the updated food menu and food items.
     */
    int updateFoodMenu(FoodMenuDto foodMenuDto);

    /**
     * Delete a food menu by its details.
     *
     * @param foodMenu The food menu object to delete.
     * @return true if the food menu is deleted, false otherwise.
     */
    boolean deleteFoodMenu(FoodMenu foodMenu);
}
