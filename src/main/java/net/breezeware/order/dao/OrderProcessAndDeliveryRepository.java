package net.breezeware.order.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.order.dto.ActiveOrderDto;
import net.breezeware.order.dto.DisplayFoodItemDto;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.entity.Order;
import net.breezeware.order.entity.OrderList;
import net.breezeware.order.enumeration.OrderStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessAndDeliveryRepository {
    Connection connection;
    public static final String ORDER_TABLE="\"order\"";
    public static final String ORDER_ITEM_TABLE="order_item";
    public List<ActiveOrderDto> retrieveListOfActiveOrders(){
        List<Order> orders=new ArrayList<>();
        List<ActiveOrderDto> activeOrderDtos=new ArrayList<>();
        DisplayFoodItemDto displayFoodItemDto = null;
        try{
            connection= DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+ORDER_TABLE+" ORDER BY delivery_on");
            while(resultSet.next()){
                if(resultSet.getString("status").equals((OrderStatus.ORDER_PLACED).toString())){
                    orders.add(new Order(resultSet.getInt("id"),resultSet.getInt("user_id"),resultSet.getDouble("total_cost"),
                            resultSet.getString("email"),resultSet.getString("phone_number"),resultSet.getString("order_location"),
                            resultSet.getString("status"),resultSet.getString("order_on"),resultSet.getString("delivery_on")));
                }
            }
            resultSet.close();
            statement.close();
            for (var order:
                 orders) {
                List<FoodItemDto> foodItemDtos=new ArrayList<>();
                Statement statement1=connection.createStatement();
                ResultSet resultSet1=statement1.executeQuery("SELECT * FROM "+ORDER_ITEM_TABLE+" WHERE order_id="+order.getId());
                while(resultSet1.next()){
                    foodItemDtos.add(new FoodItemDto(resultSet1.getInt("food_item_id"),resultSet1.getInt("quantity"),resultSet1.getDouble("cost")));
                }
                resultSet1.close();
                statement.close();
                List<DisplayFoodItemDto>displayFoodItemDtos=new ArrayList<>();
                for (var foodItemDto:
                     foodItemDtos) {
                    Statement statement2=connection.createStatement();
                    ResultSet resultSet2=statement2.executeQuery("SELECT * FROM food_item WHERE id="+foodItemDto.getFoodItemId());
                    if(resultSet2.next()){
                        displayFoodItemDto=new DisplayFoodItemDto(foodItemDto,resultSet2.getString("name"));
                    }
                    displayFoodItemDtos.add(displayFoodItemDto);
                    resultSet2.close();
                    statement2.close();
                }
                activeOrderDtos.add(new ActiveOrderDto(order,displayFoodItemDtos));
            }
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return activeOrderDtos;
    }
}
