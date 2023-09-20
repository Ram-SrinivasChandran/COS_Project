package net.breezeware.user.service.api;

import net.breezeware.user.entity.User;

import java.sql.SQLException;

/**
 * A service interface for managing user-related operations.
 */
public interface UserService {
    /**
     * Add a new user to the system.
     *
     * @param user The user object to be added.
     * @return An integer indicating the result of the operation with recordsChanged Count.
     */
    int addUser(User user);
    /**
     * Authenticate a user by their username and password.
     *
     * @param userName The username of the user.
     * @param password The user's password.
     * @return The name of the authenticated user or null if authentication fails.
     * @throws SQLException if there is an issue with database operations.
     */
    String loginUser(String userName, String password) throws SQLException;
}
