<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/10/2024
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between">
        <h2>Managerment Product</h2>
        <div>
            <input type="text" href="#">
            <button>Tìm kiếm</button>
        </div>

        <a href="/products/create" class="btn btn-primary">Add Product</a>
    </div>
    <div>
        <table class="table text-center">
            <tr>
                <th>STT</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            <c:forEach var="product" items="${products}" varStatus="stt">
                <tr>
                    <th>${stt.count}</th>
                    <th>${product.name}</th>
                    <th>${product.price}</th>
                    <th>${product.quantity}</th>
                    <th>${product.color}</th>
                    <th>${product.description}</th>
                    <th>
                        <a href="/products/delete?id=${product.id}" class="btn btn-primary btn-sm fst-normal" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">Delete</a>
                        <a href="/products/update?id=${product.id}" class="btn btn-primary btn-sm fst-normal" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">Update</a>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
