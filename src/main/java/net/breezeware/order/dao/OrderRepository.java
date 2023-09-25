package net.breezeware.order.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.PlaceOrderDto;
import net.breezeware.order.dto.ViewFoodMenuDto;
import net.breezeware.order.entity.Order;
import net.breezeware.order.enumeration.OrderStatus;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderRepository {
    Connection connection;
    public static final String TABLE_NAME_ORDER="order";
    public List<ViewFoodMenuDto> viewFoodMenu(Days day){
        List<Integer>foodMenuIds=new ArrayList<>();
        List<ViewFoodMenuDto> viewFoodMenuDtos=new ArrayList<>();
        try{
            connection= DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM food_menu WHERE availabilityOn='"+ day+"'");
            while(resultSet.next()){
                foodMenuIds.add(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            for (var foodMenuId:
                 foodMenuIds) {
                FoodMenu foodMenu = null;
                Statement statement3=connection.createStatement();
                ResultSet resultSet3=statement3.executeQuery("SELECT * FROM food_menu WHERE id="+foodMenuId);
                if(resultSet3.next()){
                    foodMenu=new FoodMenu(resultSet3.getInt("id"),resultSet3.getString("name"),resultSet3.getString("type"),resultSet3.getString("availabilityOn"));
                }
                resultSet3.close();
                statement3.close();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM food_menu_food_item_map WHERE food_menu_id=" + foodMenuId);
                List<Integer>foodItemId=new ArrayList<>();
                List<FoodItem>foodItems=new ArrayList<>();
                while (resultSet1.next()) {
                    foodItemId.add(resultSet1.getInt("food_item_id"));
                }
                resultSet1.close();
                statement1.close();
                for (var foodItem :
                        foodItemId) {
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM food_Item WHERE id=" + foodItem);
                    if (resultSet2.next()) {
                        foodItems.add(new FoodItem(resultSet2.getInt("id"),resultSet2.getString("name"),resultSet2.getDouble("cost"),resultSet2.getInt("quantity")));
                    }
                    resultSet2.close();
                    statement2.close();
                    viewFoodMenuDtos.add(new ViewFoodMenuDto(foodMenu,foodItems));
                }
                connection.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return viewFoodMenuDtos;
    }
    public boolean userCheck(int userId){
        boolean checkUser=false;
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM user WHERE id='"+userId+"'");
            if(resultSet.next()){
                   if(resultSet.getString("role").equals("Customer")){
                       checkUser=true;
                   }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return checkUser;
    }
    public void orderInCart(int orderId,int userId){
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            PreparedStatement statement=connection.prepareStatement("INSERT INTO \""+TABLE_NAME_ORDER+"\" (id,user_id,status) VALUES (?,?,?)");
            statement.setInt(1,orderId);
            statement.setInt(2,userId);
            statement.setString(3, String.valueOf(OrderStatus.IN_CART));
            statement.execute();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public Order viewOrder(int orderId){
        Order order=null;
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM \""+TABLE_NAME_ORDER+"\" WHERE id="+orderId);
            if(resultSet.next()){
                order=new Order(resultSet.getInt("id"),resultSet.getInt("user_id"),resultSet.getDouble("total_cost"),resultSet.getString("status"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return order;
    }

    public int placeOrder(int orderId,PlaceOrderDto placeOrderDto){
        int recordsChange=0;
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE \""+TABLE_NAME_ORDER+"\" SET email=?,phone_number=?,order_location=?,status=?,order_on=?,delivery_on=? WHERE id="+orderId);
            preparedStatement.setString(1,placeOrderDto.getEmail());
            preparedStatement.setString(2, placeOrderDto.getPhoneNumber());
            preparedStatement.setString(3,placeOrderDto.getOrderLocation());
            preparedStatement.setString(4, String.valueOf(OrderStatus.ORDER_PLACED));
            preparedStatement.setString(5, String.valueOf(Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime()));
            preparedStatement.setString(6, String.valueOf(Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime().plus(Duration.ofHours(1))));
            recordsChange = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return recordsChange;
    }

}
