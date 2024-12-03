package com.demo.test.service.categories;

import com.demo.test.model.Categories;
import com.demo.test.repository.categories.CategoriesRepo;
import com.demo.test.repository.categories.ICategoriesRepo;

import java.util.List;
import java.util.Optional;

public class CategoriesService implements ICategoriesService {
    private final ICategoriesRepo categoriesRepo = new CategoriesRepo();

    public CategoriesService() {
    }

    // CREAT
    @Override
    public void addCategories(Categories categories) {
        categoriesRepo.addCategories(categories);
    }

    // FIND
    @Override
    public List<Categories> findAllCategories() {
        return categoriesRepo.findAllCategories();
    }

    @Override
    public Optional<Categories> findCategoriesById(int categories_id) {
        return categoriesRepo.findCategoriesById(categories_id);
    }

    @Override
    public Optional<Categories> findCategoriesByName(String categories_name) {
        return categoriesRepo.findCategoriesByName(categories_name);
    }

    // UPDATE
    @Override
    public void updateCategories(Categories categories) {
        categoriesRepo.updateCategories(categories);
    }

    // DELETE
    @Override
    public boolean deleteCategoriesByName(String categories_name) {
        return categoriesRepo.deleteCategoriesByName(categories_name);
    }
}