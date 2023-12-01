<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.wes.myssm.entity.Teacher" %>
<%@ page import="com.wes.myssm.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>showInfo</title>
<base target="_self" />
<link rel="icon" href="./favicon.ico" />
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script language="javascript">
$(function() {
	 //選擇所有以 "date" 開頭的id
	$("[id^='date']").each(function(index) {
        var dateValue = $(this).val();
        var formattedDate = new Date(dateValue).toLocaleDateString('en-US', { year: 'numeric', month: '2-digit', day: '2-digit' });
        $("#showDate" + index).text(formattedDate);
    });
});
</script>
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

.textbody h1{
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
	width: 700px;
}


 table, tr, th, td {
 	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
 }

/* td { */
/* 	padding: 0 5px; */
/* } */
</style>
</head>
<body>
	<div class="textbody">
 		<h1>個人資料</h1><!--returnLogin -->
		<a class="btn btn-outline-dark mt-4" href="${pageContext.request.contextPath}/returnLogin"><strong>登出</strong></a>
	</div>
	<div class="infoBody">
		<table>
			<thead>
				<tr>
					<th>編號</th>
					<th>姓名</th>
					<th>生日</th>
					<th>性別</th>
					<th>信箱</th>
					<th>密碼</th>
					<c:choose>
    					<c:when test="${message.getClass().getName() eq 'com.wes.myssm.entity.Student'}">
        					<th>指導老師</th>
    					</c:when>
					</c:choose>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${message.getNo()}</td>
					<td>${message.getName()}</td>
					<td>${message.getFormatDate()}</td>
					<td>${message.getSex() == 0 ? "女性" : "男性"}</td>
					<td>${message.getMail()}</td>
					<td>${message.getCpwd()}</td>
					<c:choose>
    					<c:when test="${message.getClass().getName() eq 'com.wes.myssm.entity.Student'}">
        					<td>${message.getTeacher().getName()}</td>
    					</c:when>
					</c:choose>
				</tr>
			</tbody>
		</table>
	</div>
	<form action="${pageContext.request.contextPath}/returnUpdate" method="post">
	
	<c:if test="${message.getClass().getName() eq 'com.wes.myssm.entity.Teacher'}">
		<div class="textbody">
			<h2>學生資料表</h2>
		</div>
		<div class="infoBody">
			<table>
				<thead>
					<tr>
						<th>編號</th>
						<th>姓名</th>
						<th>生日</th>
						<th>性別</th>
						<th>信箱</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${message.getStudent()}" varStatus="status">
						<tr>
							<td>${student.no}</td>
							<td>${student.name}</td>
							<td id="showDate${status.index}">${student.formatDate}</td>
							<td>${student.sex == 0 ? "女性" : "男性"}</td>
							<td>${student.mail}</td>
							<input type="hidden" value="${student.bday}" id="date${status.index}">
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<form action="${pageContext.request.contextPath}/returnBook" method="post">
		<input type="hidden" name="no" value="${message.getNo()}">
		<input type="hidden" name="name" value="${message.getName()}">
		<input type="hidden" name="pwd" value="${pwd}">
		<input class="btn btn-outline-dark mt-4" type="submit" value="使用圖書系統" >
	</form>
</body>
</html>