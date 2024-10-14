<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        padding: 20px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    form {
        max-width: 500px;
        margin: auto;
        background: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    label {
        display: block;
        margin: 10px 0 5px;
        color: #333;
    }
    input[type="text"], input[type="password"] {
        width: 95%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    button {
        width: 100%;
        padding: 10px;
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
    .links {
        text-align: center;
        margin-top: 20px;
    }
    .links a {
        color: #007bff;
        text-decoration: none;
        margin: 0 10px;
    }
    .links a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h1>회원정보 수정</h1>
    <form action="accountUpdateDB.ac" method="get">
        <label for="account_id">아이디</label>
        <input type="text" name="account_id" value="${updateUserDTO.account_id }" id="account_id" autocomplete="off" required>

        <label for="account_pw">비밀번호</label>
        <input type="password" name="account_pw" value="${updateUserDTO.account_pw }" id="account_pw" autocomplete="off" required>

        <label for="account_name">이름</label>
        <input type="text" name="account_name" value="${updateUserDTO.account_name }" id="account_name" autocomplete="off" required>

        <label for="account_phone">전화번호</label>
        <input type="text" name="account_phone" value="${updateUserDTO.account_phone }" id="account_phone" autocomplete="off" required>

        <label for="account_address">주소</label>
        <input type="text" name="account_address" value="${updateUserDTO.account_address }" id="account_address" autocomplete="off" required>

        <button type="submit" id="btn">회원정보 수정</button>
    </form>
    <div class="links">
        <a href="accountDelete.ac">회원 탈퇴</a>
        <a href="login.ac">메인으로 가기</a>
    </div>
</body>
</html>