package com.demo.test.repository.user;

import com.demo.test.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IUserRepo {
    // Create
    void addUser(User user);

    // Find
    Optional<User> findUserByID(int userID);
    List<User> findAllUsers();
    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User>  findByUsername(String username);
    boolean hasHigherRole(String username, String targetUsername);

    // Update
    void updateUser(User user);

    // Delete
    boolean deleteUserByID(int userID);

    // Phương thức ánh xạ từ ResultSet sang đối tượng User
    User mapUser(ResultSet rs) throws SQLException;
}