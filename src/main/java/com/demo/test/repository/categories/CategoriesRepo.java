package com.demo.test.repository.categories;

import com.demo.test.model.Categories;
import com.demo.test.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriesRepo implements ICategoriesRepo {

    // Các câu truy vấn SQL
    private static final String INSERT_CATEGORIES = "INSERT INTO Categories (categories_name, categories_img, categories_createdDate, categories_updatedDate) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM Categories";
    private static final String SELECT_CATEGORIES_BY_ID = "SELECT * FROM Categories WHERE categories_id = ?";
    private static final String SELECT_CATEGORIES_BY_NAME = "SELECT * FROM Categories WHERE categories_name = ?";
    private static final String UPDATE_CATEGORIES = "UPDATE Categories SET categories_name = ?, categories_img = ?, categories_createdDate = ?, categories_updatedDate = ? WHERE categories_id = ?";
    private static final String DELETE_CATEGORIES_BY_NAME = "DELETE FROM Categories WHERE categories_name = ?";

    // Create
    @Override
    public void addCategories(Categories categories) {
        try (Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORIES)) {

            preparedStatement.setString(1, categories.getCategories_name());
            preparedStatement.setString(2, categories.getCategories_img());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(categories.getCategories_createdDate()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(categories.getCategories_updatedDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /// Find
    @Override
    public List<Categories> findAllCategories() {
        List<Categories> categories = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                categories.add(mapCategories(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Optional<Categories> findCategoriesById(int categories_id) {
        try (Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORIES_BY_ID)) {
            preparedStatement.setInt(1, categories_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapCategories(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Categories> findCategoriesByName(String categories_name) {
        try (Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORIES_BY_NAME)) {
            preparedStatement.setString(1, categories_name.trim());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapCategories(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    // Update
    public void updateCategories(Categories categories) {
        try(Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIES)) {
            preparedStatement.setString(1, categories.getCategories_name());
            preparedStatement.setString(2, categories.getCategories_img());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(categories.getCategories_createdDate()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(categories.getCategories_updatedDate()));
            preparedStatement.setInt(5, categories.getCategories_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /// Delete
    public boolean deleteCategoriesByName(String categories_name) {
        try(Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORIES_BY_NAME)) {
            preparedStatement.setString(1, categories_name);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Phương thức ánh xạ từ ResultSet sang đối tượng Categories
    @Override
    public Categories mapCategories(ResultSet rs) throws SQLException {
        return new Categories(
                rs.getInt("categories_id"),
                rs.getString("categories_name"),
                rs.getString("categories_img"),
                rs.getTimestamp("categories_createdDate").toLocalDateTime(),
                rs.getTimestamp("categories_updatedDate").toLocalDateTime()
        );
    }
}
