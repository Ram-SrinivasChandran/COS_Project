package net.breezeware.order.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.dto.OrderUpdateDto;
import net.breezeware.order.dto.OrderViewResponseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderListRepository {
    Connection connection;
    public static final String ORDER_ITEM_TABLE = "order_item";

    public List<FoodItemDto> getFoodItemCost(List<FoodItemDto>foodItems){
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            for(int i=0;i<foodItems.size();i++){
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT * FROM food_item WHERE id="+ foodItems.get(i).getFoodItemId());
                if (resultSet.next()){
                    foodItems.get(i).setFoodCost(resultSet.getDouble("cost"));
                    foodItems.get(i).setTotalQuantity(resultSet.getInt("quantity"));
                    if(foodItems.get(i).getTotalQuantity()< foodItems.get(i).getFoodItemQuantity()){
                        System.out.println(resultSet.getString("name")+" is less than Your Required Quantity.");
                        foodItems.get(i).setFoodItemId(-(i));
                    }
                }else{
                    System.out.println("No Food Item Available with the Given Id.");
                    foodItems.get(i).setFoodItemId(-(i));
                }
                resultSet.close();
                statement.close();
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return foodItems;
    }
    public void addFoodOrderItem(int orderId, List<FoodItemDto>foodItems){
        try{
            connection= DataBaseConnection.getConnection();
            assert connection != null;
            for (var foodItem:
                 foodItems) {
                if(foodItem.getFoodItemId()>0){
                    PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO "+ORDER_ITEM_TABLE+" (order_id,food_item_id,quantity,cost) VALUES (?,?,?,?)");
                    preparedStatement.setInt(1,orderId);
                    preparedStatement.setInt(2,foodItem.getFoodItemId());
                    preparedStatement.setInt(3,foodItem.getFoodItemQuantity());
                    preparedStatement.setDouble(4,(foodItem.getFoodCost()*foodItem.getFoodItemQuantity()));
                    preparedStatement.execute();
                    preparedStatement.close();
                }
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void updateOrderCost(int orderId){
        double totalCost=0;
        try{
            connection =DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+ORDER_ITEM_TABLE+" WHERE order_id="+orderId);
            while (resultSet.next()){
                totalCost+=resultSet.getDouble("cost");
            }
            resultSet.close();
            statement.close();
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE \"order\" SET total_cost=? WHERE id="+orderId);
            preparedStatement.setDouble(1,totalCost);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void updateFoodItemQuantity(List<FoodItemDto>foodItems){
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            for (var foodItem:
                 foodItems) {
                if(foodItem.getFoodItemId()>0){
                    PreparedStatement preparedStatement=connection.prepareStatement("UPDATE food_item SET quantity=? WHERE id="+foodItem.getFoodItemId());
                    preparedStatement.setInt(1,foodItem.getTotalQuantity()-foodItem.getFoodItemQuantity());
                    preparedStatement.execute();
                    preparedStatement.close();
                }
            }
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void viewOrderItems(int orderId){
        List<OrderViewResponseDto>orderViewResponses=new ArrayList<>();
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+ORDER_ITEM_TABLE+" WHERE order_id="+orderId);
            while(resultSet.next()){
                orderViewResponses.add(new OrderViewResponseDto(resultSet.getInt("food_item_id"), resultSet.getInt("quantity"),resultSet.getDouble("cost")));
            }
            resultSet.close();
            statement.close();
            for (var orderViewResponse:
                 orderViewResponses) {
                Statement statement1=connection.createStatement();
                ResultSet resultSet1=statement1.executeQuery("SELECT * FROM food_item WHERE id="+orderViewResponse.getFoodItemId());
                if(resultSet1.next()){
                    System.out.println("Food ID : "+orderViewResponse.getFoodItemId()+
                            ", Food Name : "+resultSet1.getString("name")+
                            ", Quantity : "+orderViewResponse.getFoodItemQuantity()+
                            ", Cost : "+orderViewResponse.getFoodItemCost());
                }
                resultSet1.close();
                statement1.close();
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void getFoodItemCost(OrderUpdateDto orderUpdateDto){
        int quantity=0;
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+ORDER_ITEM_TABLE+" WHERE order_id="+orderUpdateDto.getOrderId()+" AND food_item_id="+orderUpdateDto.getFoodItemId());
            if(resultSet.next()){
                orderUpdateDto.setOldQuantity(resultSet.getInt("quantity"));
            }
            resultSet.close();
            statement.close();
            Statement statement1=connection.createStatement();
            ResultSet resultSet1=statement1.executeQuery("SELECT * FROM food_item WHERE id="+orderUpdateDto.getFoodItemId());
            if(resultSet1.next()){
                orderUpdateDto.setCost(resultSet1.getDouble("cost"));
                int extraQuantity= orderUpdateDto.getNewQuantity()-orderUpdateDto.getOldQuantity();
                if(orderUpdateDto.getOldQuantity()<orderUpdateDto.getNewQuantity()){
                    if(orderUpdateDto.getNewQuantity()-orderUpdateDto.getOldQuantity()>resultSet1.getInt("quantity")){
                        System.out.println(resultSet1.getString("name")+" is less than Your Required Quantity.");
                    }else{
                        quantity=resultSet1.getInt("quantity")+extraQuantity;
                    }
                }else{
                    quantity=resultSet1.getInt("quantity")+extraQuantity;
                }
            }
            resultSet1.close();
            statement1.close();
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE food_item SET quantity=? WHERE id="+orderUpdateDto.getFoodItemId());
            preparedStatement.setInt(1,quantity);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void UpdateOrderItem(OrderUpdateDto updateDate){
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE "+ORDER_ITEM_TABLE+" SET quantity=?,cost=? WHERE order_id="+updateDate.getOrderId()+" AND food_item_id="+updateDate.getFoodItemId());
            preparedStatement.setInt(1,updateDate.getNewQuantity());
            preparedStatement.setDouble(2,(updateDate.getCost()*updateDate.getNewQuantity()));
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
