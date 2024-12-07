package com.demo.test.service.categories;

import com.demo.test.model.Categories;
import com.demo.test.model.Product;

import java.util.List;
import java.util.Optional;

public interface ICategoriesService {
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

}
