package com.codegym.thi_md3.services;

import com.codegym.thi_md3.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void insertProduct(Product product);
    void deleteProduct(int id);
    Product selectProduct(int id);
    void updateProduct(Product product);
}
