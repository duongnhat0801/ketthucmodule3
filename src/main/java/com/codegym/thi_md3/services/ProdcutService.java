package com.codegym.thi_md3.services;

import com.codegym.thi_md3.models.Product;
import com.codegym.thi_md3.repositories.IProductRepo;
import com.codegym.thi_md3.repositories.ProductRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProdcutService implements IProductService {
    IProductRepo productRepo = new ProductRepo();

    @Override
    public List<Product> selectAll() {
        try {
            return productRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertProduct(Product product) {
        try {
            productRepo.insertProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            productRepo.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        try {
            return productRepo.selectProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            productRepo.updateProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


