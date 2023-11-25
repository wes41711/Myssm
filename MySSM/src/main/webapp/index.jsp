<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<base target="_self" />
<link rel="icon" href="./favicon.ico" />
<title>Welcome MySSM</title>
<style>
body {
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

.textbody {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.textbody h1 {
	font-size: 50px;
	letter-spacing: 1.5px;
}
</style>
<script language="javascript">

</script>
</head>
<body>
	<div class="textbody">
		<h1>歡迎使用師生圖書系統</h1>
		<a class="btn btn-outline-dark btn-lg mt-5"
		   href="${pageContext.request.contextPath}/returnLogin"><strong>登入</strong></a>
		<a class="btn btn-outline-dark btn-lg mt-5"
		   href="${pageContext.request.contextPath}/returnSignIn"><strong>註冊</strong></a>
	</div>

</body>
</html>
