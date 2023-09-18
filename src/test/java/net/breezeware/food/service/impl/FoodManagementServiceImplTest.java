package net.breezeware.food.service.impl;

import net.breezeware.food.dao.FoodItemRepository;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.service.api.FoodManagementService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FoodManagementServiceImplTest {

    FoodManagementService foodManagementService = new FoodManagementServiceImpl();

    @Test
    void addFoodItem() {
        FoodItem foodItem = new FoodItem(1,"idly",10,2);
        foodManagementService.addFoodItem(foodItem);
    }
}