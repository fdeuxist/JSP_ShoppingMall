<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 완료</title>
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
    button {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <c:if test="${sessionScope.account_id=='' }">
        <c:redirect url="login.jsp?isLogin=false"></c:redirect>	
    </c:if>
    <c:if test="${not empty sessionScope.account_id}">
        <h1>회원 가입 완료</h1>
        <div class="message">
            ${sessionScope.account_id }님 환영합니다.
        </div>
        <form action="fromJoinToLogin.ac" method="get">
            <button type="submit">로그인하러 가기</button>
        </form>
    </c:if>
</body>
</html>