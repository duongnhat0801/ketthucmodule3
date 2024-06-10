package com.codegym.thi_md3.controllers;

import com.codegym.thi_md3.models.Product;
import com.codegym.thi_md3.services.IProductService;
import com.codegym.thi_md3.services.ProdcutService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductServlet", urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProdcutService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                listProduct(req, resp);
                break;
            case "/create":
                showFormCreateProduct(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            case "/update":
                showFormUpdateProduct(req, resp);
                break;
        }
    }

    private void showFormUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.selectProduct(id);
        System.out.println(product.getId());
        req.setAttribute("product", product);
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.sendRedirect("/products/list");
    }

    private void showFormCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/listProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ádasdasd");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                createProduct(req, resp);
                break;
            case "/update":
                updateProduct(req, resp);
                break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        Product product = new Product(name, price, quantity, color, description);
        productService.updateProduct(product);
        resp.sendRedirect("/products/list");

    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        Product product = new Product(name, price, quantity, color, description);
        productService.insertProduct(product);
        resp.sendRedirect("/products/list");
    }
}


