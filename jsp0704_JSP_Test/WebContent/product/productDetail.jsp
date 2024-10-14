<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
    }
    .product-detail-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-top: 20px;
        max-width: 400px;
        margin: 20px auto;
    }
    .product-detail-container img {
        width: 50%;
        height: auto;
        border-radius: 10px;
    }
    .product-detail-container h2 {
        margin: 10px 0;
    }
    .product-detail-container p {
        margin: 5px 0;
    }
    .product-detail-container .price {
        color: #e91e63;
        font-size: 1.5em;
        font-weight: bold;
    }
    .product-detail-container button {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border: none;
        border-radius: 5px;
        font-size: 1em;
        margin-top: 20px;
    }
    .product-detail-container button:hover {
        background-color: #0056b3;
    }
    .links {
        margin-top: 20px;
    }
    .links a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
        margin: 5px;
    }
    .links a:hover {
        background-color: #0056b3;
    }
</style>
<script>
	if (
<%=request.getParameter("isPutInCart")%>
	== true) {
		alert('장바구니에 담았습니다.');
	} 
</script>
</head>
<body>
    <h1>상품 상세 정보</h1>
    <div class="product-detail-container">
        <img src="${request.getContextPath() }imgs${productDTO.pdt_imgpath }" alt="${productDTO.pdt_name }">
        <h2>${productDTO.pdt_name }</h2>
        <p>상품 번호: ${productDTO.pdt_no }</p>
        <p class="price">${productDTO.pdt_cost }원</p>
        <form action="addToCart.pdt" method="get">
            <input type="hidden" name="pdt_no" value="${productDTO.pdt_no }">
            <input type="hidden" name="pdt_name" value="${productDTO.pdt_name }">
            <input type="hidden" name="pdt_cost" value="${productDTO.pdt_cost }">
            <input type="hidden" name="pdt_imgpath" value="${productDTO.pdt_imgpath }">
            <button type="submit" id="btn">장바구니 담기</button>
        </form>
    </div>
    <div class="links">
        <a href="products.pdt">목록으로 가기</a>
        <a href="cart.pdt">장바구니로 가기</a>
    </div>
</body>
</html>
