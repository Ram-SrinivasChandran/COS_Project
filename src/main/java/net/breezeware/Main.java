package net.breezeware;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection=getConnection();
            assert connection != null;
            Statement statement=connection.createStatement();
//            statement.execute("INSERT INTO user(id,name,user_name,password,role) VALUES (1,'RAM','ram_06','breeze123','ADMIN')");
            statement.close();
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:sqlite:/home/ram/Project/Github/cos_project/db/cafeteria_service.db");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}