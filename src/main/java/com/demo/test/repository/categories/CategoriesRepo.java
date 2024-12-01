package com.demo.test.repository.categories;

import com.demo.test.model.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CategoriesRepo implements ICategories {

    // Các câu truy vấn SQL
    private static final String INSERT_CATEGORY = "INSERT INTO categories (categories_name) VALUES (?)";

    @Override
    public void addCategories(Categories Categories) {

    }

    @Override
    public Optional<Categories> findAllCategories() {
        return Optional.empty();
    }

    @Override
    public Optional<Categories> findCategoriesByName(String categories_name) {
        return Optional.empty();
    }

    @Override
    public void updateCategories(Categories Categories) {

    }

    @Override
    public boolean deleteCategories(String categories_name) {
        return false;
    }

    @Override
    public Categories mapCategories(ResultSet rs) throws SQLException {
        return null;
    }
}
