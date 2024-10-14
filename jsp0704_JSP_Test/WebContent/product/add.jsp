<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
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
    input[type="text"] {
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
</head>
<body>
    <h1>상품 등록</h1>
    <form action="addDB.pdt" method="get">
        <label for="pdt_name">상품명</label>
        <input type="text" name="pdt_name" id="pdt_name" autocomplete="off" required> 
        
        <label for="pdt_cost">가격</label>
        <input type="text" name="pdt_cost" id="pdt_cost" autocomplete="off" required> 
        
        <label for="pdt_imgpath">이미지 경로</label>
        <input type="text" name="pdt_imgpath" id="pdt_imgpath" autocomplete="off" required> 
        
        <button type="submit" id="btn">등록</button>
    </form>
</body>
</html>
