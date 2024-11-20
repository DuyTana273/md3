package com.demo.test.service.user;

import com.demo.test.model.User;
import com.demo.test.repository.user.IUserRepo;
import com.demo.test.repository.user.UserRepo;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserRepo iUserRepo = new UserRepo();

    public UserService() {
    }

    // Create
    @Override
    public void addUser(User user) {
        iUserRepo.addUser(user);
    }

    // Find
    @Override
    public Optional<User> findUserByID(int userId) {
        return iUserRepo.findUserByID(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return iUserRepo.findAllUsers();
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        return iUserRepo.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return iUserRepo.findByUsername(username);
    }

    @Override
    public boolean hasHigherRole(String username, String targetUsername) {
        return iUserRepo.hasHigherRole(username, targetUsername);
    }

    // Update
    @Override
    public void updateUser(User user) {
        iUserRepo.updateUser(user);
    }

    // Delete
    @Override
    public boolean deleteUserByID(int userID) {
        return iUserRepo.deleteUserByID(userID);
    }
}
