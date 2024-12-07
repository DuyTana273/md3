package com.demo.test.service.product;

import com.demo.test.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    // Create
    void addProduct(Product product);

    // Find
    List<Product> findAllProducts();
    Optional<Product> findProductById(int product_id);
    Optional<Product> findProductByName(String product_name);
    List<Product> searchProduct(String searchKeyword);

    // Update
    void updateProduct(Product product);

    // Delete
    boolean deleteProductById(int product_id);
    boolean deleteProductByName(String product_name);

}
