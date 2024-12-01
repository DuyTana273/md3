package com.demo.test.repository.categories;


import com.demo.test.model.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface ICategories {
    // Create
    void addCategories(Categories Categories);

    // Find
    Optional<Categories> findAllCategories();
    Optional<Categories> findCategoriesByName(String categories_name);

    // Update
    void updateCategories(Categories Categories);

    // Delete
    boolean deleteCategories(String categories_name);

    // Ánh Xạ
    Categories mapCategories(ResultSet rs) throws SQLException;
}
