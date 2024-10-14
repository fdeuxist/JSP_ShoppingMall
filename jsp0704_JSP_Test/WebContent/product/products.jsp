<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
    }
    .product-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }
    .product-card {
        border: 1px solid #ccc;
        border-radius: 10px;
        width: 200px;
        margin: 15px;
        padding: 15px;
        text-align: center;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .product-card img {
        width: 50%;
        height: auto;
        border-radius: 10px 10px 0 0;
    }
    .product-card h3 {
        margin: 10px 0;
    }
    .product-card p {
        margin: 5px 0;
    }
    .product-card .price {
        color: #e91e63;
        font-size: 1.2em;
        font-weight: bold;
    }
    .product-card a {
        display: block;
        margin-top: 10px;
        padding: 10px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        
        
    }
    .product-card a:hover {
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
<h1>상품 목록</h1>
<div class="product-container">
    <c:forEach var="productDto" items="${productDtos }" varStatus="status">
    <div class="product-card">
        <img src="${request.getContextPath() }imgs${productDto.pdt_imgpath }" alt="${productDto.pdt_name }" style="width: 70px; height: 110px; object-fit: contain;">
        <h3>${productDto.pdt_name }</h3>
        <p>상품번호: ${productDto.pdt_no }</p>
        <p class="price">${productDto.pdt_cost }원</p>
        <a href="productDetail.pdt?pdt_no=${productDto.pdt_no}">상세 보기</a>
    </div>
    </c:forEach>
</div>
<a href="../account/success.ac" class="main-page-link">메인 페이지로</a>
</body>
</html>
