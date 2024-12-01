package com.demo.test.repository.user;

import com.demo.test.model.User;
import com.demo.test.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepo implements IUserRepo {

    // Các câu truy vấn SQL
    private static final String INSERT_USER = "INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM Users";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM Users WHERE userID = ?";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM Users WHERE username = ? AND password = ?";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM Users WHERE username = ?";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM Users WHERE email = ?";
    private static final String UPDATE_USER = "UPDATE Users SET username = ?, password = ?, fullName = ?, email = ?, phone = ?, address = ?, avatar = ?, userCreatedDate = ?, userUpdatedDate = ?, userStatus = ?, userRole = ? WHERE userID = ?";
    private static final String DELETE_USER_BY_USERNAME = "DELETE FROM Users WHERE username = ?";

    // Create
    @Override
    public void addUser(User user) {
        try (Connection connection = BaseRepository.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getFullName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getAddress());
                preparedStatement.setString(7, user.getAvatar());
                preparedStatement.setTimestamp(8, Timestamp.valueOf(user.getUserCreatedDate()));
                preparedStatement.setTimestamp(9, Timestamp.valueOf(user.getUserUpdatedDate()));
                preparedStatement.setString(10, user.getUserStatus());
                preparedStatement.setString(11, user.getUserRole());

                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Find
    @Override
    public Optional<User> findUserByID(int userID) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // Update
    @Override
    public void updateUser(User user) {
        try (Connection connection = BaseRepository.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getFullName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getAddress());
                preparedStatement.setString(7, user.getAvatar());
                preparedStatement.setTimestamp(8, Timestamp.valueOf(user.getUserCreatedDate()));
                preparedStatement.setTimestamp(9, Timestamp.valueOf(user.getUserUpdatedDate()));
                preparedStatement.setString(10, user.getUserStatus());
                preparedStatement.setString(11, user.getUserRole());
                preparedStatement.setInt(12, user.getUserID());

                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    @Override
    public boolean deleteUserByUsername(String username) {
        try (Connection connection = BaseRepository.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_USERNAME)) {
                preparedStatement.setString(1, username);
                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                return false;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Phương thức ánh xạ từ ResultSet sang đối tượng User
    @Override
    public User mapUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("userID"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fullName"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getString("avatar"),
                rs.getTimestamp("userCreatedDate").toLocalDateTime(),
                rs.getTimestamp("userUpdatedDate").toLocalDateTime(),
                rs.getString("userStatus"),
                rs.getString("userRole")
        );
    }
}
