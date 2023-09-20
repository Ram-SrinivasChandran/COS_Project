package net.breezeware.user.service.impl;

import net.breezeware.user.entity.User;
import net.breezeware.user.service.api.UserService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the UserServiceImpl class.
 */
class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    /**
     * Test the 'addUser' method.
     */
    @Test
    void addUser(){
        User user=new User(1,"Seenu","ram_06","breeze123","Admin");
        assertEquals(1,userService.addUser(user));
    }
    /**
     * Test the 'loginUser' method.
     *
     * @throws SQLException if there is an issue with database operations.
     */
    @Test
    void loginUser() throws SQLException {
        // Call the 'loginUser' method with username and password
        // and assert that it returns the expected username 'Seenu'
        assertEquals("Seenu",userService.loginUser("ram_06","breeze123"));
    }
}