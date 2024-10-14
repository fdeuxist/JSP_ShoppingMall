<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="jquery-3.4.1.js"></script>
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
    form {
        max-width: 400px;
        margin: 20px auto;
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
</style>
<script>
	if (
<%=request.getParameter("isSuccess")%>
	== false) {
		alert('USER NAME 혹은 PASSWORD가 잘못 입력되었습니다.');
	} else if (
<%=request.getParameter("isLogout")%>
	== true) {
		alert('로그아웃되었습니다. 로그인페이지로 이동합니다.');
	} else if (
<%=request.getParameter("isLogin")%>
	== false) {
		alert('로그인해야 이용할 수 있는 페이지입니다. 로그인페이지로 이동합니다.');
	}
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginDB.ac" method="get">
		<label for="account_id">아이디</label> 
			<input type="text" name="account_id" value="" id="account_id" autocomplete="off" required> <br>
		<label for="account_pw">비밀번호</label> 
			<input type="password" name="account_pw" value="" id="account_pw" autocomplete="off" required>
		<button type="submit" id="btn">로그인</button>
	</form>
	<form action="join.ac" method="get">
		<button type="submit" id="btn">회원가입</button>
	</form>
	<c:if test="${sessionScope.account_id != null }">
		<c:redirect url="success.jsp"></c:redirect>	
	</c:if>
</body>
</html>
