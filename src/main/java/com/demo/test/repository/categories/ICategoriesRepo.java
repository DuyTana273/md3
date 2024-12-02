package com.demo.test.repository.categories;

import com.demo.test.model.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ICategoriesRepo {
    // Create
    void addCategories(Categories categories);

    // Find
    List<Categories> findAllCategories();
    Optional<Categories> findCategoriesById(int categories_id);
    Optional<Categories> findCategoriesByName(String categories_name);

    // Update
    void updateCategories(Categories categories);

    // Delete
    boolean deleteCategoriesByName(String categories_name);

    // Phương thức ánh xạ từ ResultSet sang đối tượng Categories
    Categories mapCategories(ResultSet rs) throws SQLException;
}