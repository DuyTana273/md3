package com.demo.test.service.product;

import com.demo.test.model.Product;
import com.demo.test.repository.product.IProductRepo;
import com.demo.test.repository.product.ProductRepo;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    private final IProductRepo iProductRepo = new ProductRepo();

    public ProductService() {
    }

    @Override
    public void addProduct(Product product) {
        iProductRepo.addProduct(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return iProductRepo.findAllProducts();
    }

    @Override
    public Optional<Product> findProductById(int product_id) {
        return iProductRepo.findProductById(product_id);
    }

    @Override
    public Optional<Product> findProductByName(String product_name) {
        return iProductRepo.findProductByName(product_name);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepo.updateProduct(product);
    }

    @Override
    public boolean deleteProductById(int product_id) {
        return iProductRepo.deleteProductById(product_id);
    }

    @Override
    public boolean deleteProductByName(String product_name) {
        return iProductRepo.deleteProductByName(product_name);
    }
}
