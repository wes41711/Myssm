<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>forgotPassword</title>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script language="javascript">
$(function() {
	if('${message}' != ""){
		alert('${message}');
	}
});
</script>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	margin-top: 50px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	font-weight: bold;
}

.form-group input[type="text"], .form-group input[type="password"] {
	width: 100%;
	padding: 8px;
	font-size: 16px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.form-group input[type="submit"] {
	background-color: #4caf50;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
}

.form-group input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h2>找回密碼</h2>
		<form action="${pageContext.request.contextPath}/forgotPassword" method="post">
			<div class="form-group">
				<label for="id">帳號:</label>
				<input type="text" id="id" name="id" required>
			</div>
			<div class="form-group">
				<label for="mail">信箱:</label>
				<input type="text" pattern="^\w+@\w+(\.\w+){1,2}$" title="請輸入正確的信箱格式" id="pwd" name="mail" required>
			</div>
			<div class="form-group">
				<input type="submit" value="發送信件">
			</div>
		</form>
		<p>
			還沒有帳號？<a class="btn btn-outline-primary btn-sm"
				href="${pageContext.request.contextPath}/returnSignIn">註冊</a> 
				<a class="btn btn-outline-dark btn-sm" href="./index.jsp"><strong>返回首頁</strong></a>
		</p>
	</div>
</body>
</html>