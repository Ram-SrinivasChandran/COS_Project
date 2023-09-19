package net.breezeware.user.service.impl;

import net.breezeware.user.entity.User;
import net.breezeware.user.service.api.UserService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    @Test
    void addUser(){
        User user=new User(1,"Seenu","ram_06","breeze123","Admin");
        assertEquals(1,userService.addUser(user));
    }
    @Test
    void loginUser() throws SQLException {
        assertEquals("Seenu",userService.loginUser("ram_06","breeze123"));
    }
}