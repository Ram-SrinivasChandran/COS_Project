package net.breezeware.user.service.api;

import net.breezeware.user.entity.User;

import java.sql.SQLException;

public interface UserService {
    int addUser(User user);
    String loginUser(String userName, String password) throws SQLException;
}
