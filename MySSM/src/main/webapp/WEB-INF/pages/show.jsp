<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>個人資料顯示頁</title>
<base target="_self" />
<link rel="icon" href="./favicon.ico" />
<style>
body {
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: flex-start;
	flex-direction: column;
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

.infoBody {
	margin-top: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

table {
	margin-bottom: 50px;
}

table {
	width: 700px;
}

table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	padding: 0 5px;
}
</style>
</head>
<body>
	<div class="textbody">
		<h1>個人資料</h1>
		<a class="btn btn-outline-dark mt-4" href="${pageContext.request.contextPath}/returnLogin"><strong>返回</strong></a>
	</div>
	<div class="infoBody">
		<table>
			<thead>
				<tr style="text-align: center;">
					<th>編號</th>
					<th>姓名</th>
					<th>生日</th>
					<th>性別</th>
					<th>信箱</th>
					<th>密碼</th>
				</tr>
			</thead>
			<tbody>
				<tr style="text-align: center;">
					<td>${message.getNo()}</td>
					<td>${message.getName()}</td>
					<td>${message.getFormatDate()}</td>
					<td>${message.getSex() == 0 ? "女性" : "男性"}</td>
					<td>${message.getMail()}</td>
					<td>${message.getCpwd()}</td>
				</tr>

			</tbody>
		</table>
	</div>
</body>
</html>