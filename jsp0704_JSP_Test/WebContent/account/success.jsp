<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        padding: 20px;
        text-align: center;
    }
    h1 {
        color: #333;
    }
    .message {
        margin: 20px 0;
        font-size: 18px;
    }
    .btn-container {
        margin: 20px 0;
    }
    button, .link-btn {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
    }
    button:hover, .link-btn:hover {
        background-color: #0056b3;
    }
    .link-btn {
        display: inline-block;
        margin: 10px;
    }
</style>
</head>
<body>
    <c:if test="${sessionScope.account_id == ''}">
        <c:redirect url="login.jsp?isLogin=false"></c:redirect>    
    </c:if>
    <c:if test="${not empty sessionScope.account_id}">
        <h1>마이 페이지</h1>
        <div class="message">
            ${sessionScope.account_id}님 환영합니다.
        </div>
        <div class="btn-container">
            <form action="accountUpdate.ac" method="get" style="display: inline;">
                <button type="submit">회원정보수정</button>
            </form>
            <form action="logout.ac" method="get" style="display: inline;">
                <button type="submit">로그아웃</button>
            </form>
        </div>
    </c:if>
    <c:if test="${sessionScope.account_id == 'admin'}">
        <div class="btn-container">
            <a href="../product/add.pdt" class="link-btn">상품 추가</a>
        </div>
    </c:if>
            <a href="../product/products.pdt" class="link-btn">상품 목록</a>
</body>
</html>