<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/10/2024
  Time: 10:03 AM
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
<form action="/products/create" method="post" id="products-form">

    <div class=" container">
        <h3>Add new product</h3>
        <div class="mb-3 form-floating">
            <input type="text" class="form-control" id="productName" placeholder="" name="productName">
            <label for="productName" class="form-label">Name</label>
        </div>
        <div class="mb-3 form-floating">
            <input type="text" class="form-control" id="productPrice" placeholder="" name="productPrice">
            <label for="productPrice" class="form-label">Price</label>
        </div>
        <div class="mb-3 form-floating">
            <input type="text" class="form-control" id="productQuantity" placeholder="" name="productQuantity">
            <label for="productQuantity" class="form-label">Quantity</label>
        </div>
        <div class="mb-3 form-floating">
            <input type="text" class="form-control" id="productColor" placeholder="" name="productColor">
            <label for="productColor" class="form-label">Color</label>
        </div>
        <div class="mb-3 form-floating">
            <input type="text" class="form-control" id="productDes" placeholder="" name="productDes">
            <label for="productDes" class="form-label">Description</label>
        </div>
        <button>Submit</button>
        <a href="/products/list" type="button">Huỷ</a>
    </div>
</form>
</body>
</html>
