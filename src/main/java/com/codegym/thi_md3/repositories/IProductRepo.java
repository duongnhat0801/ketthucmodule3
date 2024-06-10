package com.codegym.thi_md3.repositories;

import com.codegym.thi_md3.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepo {
    List<Product> selectAll() throws SQLException;
    void insertProduct(Product product) throws SQLException;
    void deleteProduct(int id) throws SQLException;
    Product selectProduct(int id) throws SQLException;
    void updateProduct(Product product) throws  SQLException;
}
