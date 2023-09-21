package net.breezeware.order.service.impl;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.service.api.OrderManagementService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderManagementServiceImplTest {
    OrderManagementService orderManagementService=new OrderManagementServiceImpl();
    @Test
    @Order(1)
    void viewFoodMenu(){
        Days day=Days.Tuesday;
        orderManagementService.viewFoodMenu(day);
    }
}