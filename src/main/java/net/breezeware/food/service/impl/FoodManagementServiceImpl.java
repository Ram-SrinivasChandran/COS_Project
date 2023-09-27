package net.breezeware.food.service.impl;

import net.breezeware.food.dao.FoodItemRepository;
import net.breezeware.food.dao.FoodMenuFoodItemRepository;
import net.breezeware.food.dao.FoodMenuRepository;
import net.breezeware.food.dto.FoodMenuDto;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.service.api.FoodManagementService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the FoodManagementService interface for managing food-related operations.
 */
public class FoodManagementServiceImpl implements FoodManagementService {
    private final FoodItemRepository foodItemRepository = new FoodItemRepository();
    private final FoodMenuFoodItemRepository foodMenuFoodItemRepository = new FoodMenuFoodItemRepository();
    private final FoodMenuRepository foodMenuRepository = new FoodMenuRepository();

    /**
     * Add a new food item to the system.
     *
     * @param foodItem The food item object to be added.
     * @return An integer indicating the result of the operation with the recordsChanged count.
     */
    public int addFoodItem(FoodItem foodItem) {
        return foodItemRepository.addFoodItem(foodItem);
    }

    /**
     * Retrieve the name of a food item by its ID.
     *
     * @param id The ID of the food item to retrieve.
     * @return The name of the retrieved food item.
     * @throws SQLException if there is an issue with database operations.
     */
    public String retrieveFoodItem(int id) throws SQLException {
        ResultSet resultSet = foodItemRepository.retrieveFoodItem(id);
        String name = resultSet.getString("name");
        resultSet.close();
        return name;
    }

    /**
     * Return a list of food items.
     */
    public List<FoodItem> retrieveFoodItems() {
        return foodItemRepository.retrieveFoodItems();
    }

    /**
     * Update a food item's information.
     *
     * @param foodItem The updated food item object.
     * @return An integer indicating the result of the operation (e.g., success or failure).
     */
    public int updateFoodItem(FoodItem foodItem) {
        int recordChanged = foodItemRepository.updateFoodItem(foodItem);
        assert recordChanged!=0;
        System.out.println("The Food Item is Updated.");
        return recordChanged;
    }

    /**
     * Delete a food item by its ID.
     *
     * @param id The ID of the food item to delete.
     */
    public int deleteFoodItem(int id) {
        int recordChanged = foodItemRepository.deleteFoodItem(id);
        assert recordChanged!=0;
        System.out.println("The Food Item with the given ID is Deleted.");
        return recordChanged;
    }

    /**
     * Add a new food menu along with its associated food items.
     *
     * @param foodMenuDto The food menu DTO contains the food menu object and list of foodItems to be added.
     * @return The name of the added food menu.
     */
    public String addFoodMenu(FoodMenuDto foodMenuDto) {
        String foodMenuDay = null;
        int foodMenuId = foodMenuRepository.addFoodMenu(foodMenuDto.getFoodMenu());
        if (foodMenuId != 0) {
            for (var foodItem : foodMenuDto.getFoodItems()) {
                addFoodItem(foodItem);
            }
            foodMenuDay = addFoodMenuFoodItemMap(foodMenuDto.getFoodItems(), foodMenuId);
            System.out.println("Food Menu is Added.");
        }
        return foodMenuDay;
    }

    /**
     * Add mappings between food items and a food menu.
     *
     * @param foodItems   The list of food items to be associated with the menu.
     * @param foodMenuId  The ID of the food menu.
     * @return The name of the added food menu.
     */
    private String addFoodMenuFoodItemMap(List<FoodItem> foodItems, int foodMenuId) {
        return foodMenuFoodItemRepository.addFoodMenuFoodItemMap(foodItems, foodMenuId);
    }

    /**
     * Return a list of food menu Dtos.
     */
    public List<FoodMenuDto> retrieveFoodMenu() {
        return foodMenuRepository.retrieveFoodMenu();
    }

    /**
     * Update a food menu and its associated food items.
     *
     * @param foodMenuDto The DTO containing the updated food menu and food items.
     */
    public int updateFoodMenu(FoodMenuDto foodMenuDto) {
        if (foodMenuRepository.validateFoodMenu(foodMenuDto.getFoodMenu().getId())) {
            List<FoodItem> foodItems = foodMenuDto.getFoodItems();
            for (var foodItem : foodItems) {
                updateFoodItem(foodItem);
            }
            return 1;
        } else {
            System.out.println("There is no menu with the given food item details.");
            return 0;
        }
    }

    /**
     * Delete a food menu by its details.
     *
     * @param foodMenuId The food menu object to delete.
     * @return true if the food menu is deleted, false otherwise.
     */
    public boolean deleteFoodMenu(int foodMenuId) {
        if (foodMenuRepository.validateFoodMenu(foodMenuId)) {
            System.out.println("The Food Menu Is Deleted.");
            return foodMenuRepository.deleteFoodMenu(foodMenuId);
        } else {
            System.out.println("There is no menu with the given food item details.");
            return false;
        }
    }
}
