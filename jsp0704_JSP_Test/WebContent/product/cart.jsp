<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
    }
    .product-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .product-card {
        display: flex;
        align-items: center;
        justify-content: space-between;
        border: 1px solid #ccc;
        border-radius: 10px;
        width: 80%;
        margin: 15px 0;
        padding: 15px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .product-card img {
        width: 50px;
        height: auto;
        border-radius: 10px;
    }
    .product-details {
        display: flex;
        align-items: center;
        flex: 1;
        margin-left: 20px;
        text-align: left;
    }
    .product-details p {
        margin: 0 10px;
    }
    .price {
        color: #e91e63;
        font-size: 1.2em;
        font-weight: bold;
    }
    .product-actions {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
    }
    .product-actions a {
        display: inline-block;
        margin-top: 10px;
        padding: 10px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }
    .product-actions a:hover {
        background-color: #0056b3;
    }
    .main-page-link {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
    }
    .main-page-link:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<h1>장바구니</h1>
<div class="product-container">
    <c:forEach var="productDto" items="${productlist }" varStatus="status">
    <div class="product-card">
        <p>${productDto.pdt_no }</p>
        <img src="${request.getContextPath() }imgs${productDto.pdt_imgpath }" alt="${productDto.pdt_name }">
        <div class="product-details">
            <p>${productDto.pdt_name }</p>
        </div>
        <div class="product-actions">
            <p class="price">${productDto.pdt_cost }원</p>
            <a href="productCartDelete.pdt?productlistIndex=${status.index}">삭제하기</a>
        </div>
    </div>
    </c:forEach>
</div>
<a href="products.pdt" class="main-page-link">목록으로 가기</a>
</body>
</html>





