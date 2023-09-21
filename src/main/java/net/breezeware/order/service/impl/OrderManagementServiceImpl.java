package net.breezeware.order.service.impl;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dao.OrderRepository;
import net.breezeware.order.service.api.OrderManagementService;

public class OrderManagementServiceImpl implements OrderManagementService {
    OrderRepository orderRepository=new OrderRepository();
    public void viewFoodMenu(Days day){
        orderRepository.viewFoodMenu(day);
    }
}
