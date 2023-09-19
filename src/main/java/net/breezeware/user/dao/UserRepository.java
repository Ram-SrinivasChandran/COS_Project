package net.breezeware.user.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.user.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepository {
    public static final String TABLE_NAME="user";
    Connection connection;
    public int addUser(User user){
        int recordeChanged=0;
        try{
            connection= DataBaseConnection.getConnection();
            assert connection != null;
            PreparedStatement statement=connection.prepareStatement("INSERT INTO "+TABLE_NAME+" VALUES (?,?,?,?,?)");
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getUserName());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getRole());
            recordeChanged=statement.executeUpdate();
            statement.close();
            connection.close();
            System.out.println("User Added.");
        }catch(Exception e){
            System.out.println("The Id is already Exists.");
        }
        return recordeChanged;
    }
    public ResultSet loginUser(String userName, String password){
        try{
            connection= DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            return statement.executeQuery("SELECT * FROM "+TABLE_NAME+" WHERE user_name= '"+userName+"' AND password= '"+password+"'");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("User name or Password incorrect.");
        return null;
    }
}
