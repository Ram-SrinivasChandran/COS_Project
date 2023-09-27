package net.breezeware.user.service.impl;

import net.breezeware.user.dao.UserRepository;
import net.breezeware.user.entity.User;
import net.breezeware.user.service.api.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of the UserService interface for managing user-related operations.
 */
public class UserServiceImpl implements UserService {
    UserRepository userRepository=new UserRepository();
    /**
     * Add a new user to the system.
     *
     * @param user The user object to be added.
     * @return An integer indicating the result of the operation with recordsChanged Count.
     */
    public int addUser(User user){
        return userRepository.addUser(user);
    }
    /**
     * Authenticate a user by their username and password.
     *
     * @param username The username of the user.
     * @param password The user's password.
     * @return The name of the authenticated user or null if authentication fails.
     * @throws SQLException if there is an issue with database operations.
     */
    public String loginUser(String username, String password) throws SQLException {
        ResultSet resultSet= userRepository.login(username,password);
        if(resultSet!=null){
            return resultSet.getString("name");
        }
        return null;
    }
}
