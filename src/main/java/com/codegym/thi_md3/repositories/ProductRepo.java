package com.codegym.thi_md3.repositories;

import com.codegym.thi_md3.database.DBConnection;
import com.codegym.thi_md3.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepo implements IProductRepo {
    @Override
    public List<Product> selectAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from product";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setQuantity(rs.getInt("quantity"));
            product.setColor(rs.getString("color"));
            product.setDescription(rs.getString("description"));
            products.add(product);
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "insert into product(name,price,quantity,color,description";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setString(4, product.getColor());
        ps.setString(5, product.getDescription());
        ps.executeUpdate();
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = " delete from product where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from product where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                product = new Product(id1, name, price, quantity, color, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "update product set name = ? ,price=?,quantity=?,color=?,description=? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setString(4, product.getColor());
        ps.setString(5, product.getDescription());
        ps.executeUpdate();
    }
}