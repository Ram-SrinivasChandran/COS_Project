package net.breezeware.user.service.impl;

import net.breezeware.user.dao.UserRepository;
import net.breezeware.user.entity.User;
import net.breezeware.user.service.api.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserRepository userRepository=new UserRepository();
    public int addUser(User user){
        return userRepository.addUser(user);
    }
    public String loginUser(String userName, String password) throws SQLException {
        ResultSet resultSet= userRepository.loginUser(userName,password);
        if(resultSet!=null){
            return resultSet.getString("name");
        }
        return null;
    }
}
