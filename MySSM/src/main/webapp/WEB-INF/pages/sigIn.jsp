<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	  rel="stylesheet" />
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" 
	  rel="stylesheet" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>signIn</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript">
$(function() {
    // 给 "產生帳號" 按鈕添加點擊事件
    $("#generateAccountBtn").click(function() {
       // 獲取選中的單選按鈕的值
       var selectedValue = $("input[name='role']:checked").val();
       // 發送 Ajax 請求生成帳號
       $.ajax({
          type: "GET",
          url: "${pageContext.request.contextPath}/generateAccount",
          data: {
             role: selectedValue
          },
          success: function(generatedAccount) {
             // 將生成的帳號設置到相應的輸入框中
             $(".generatedAccount").val(generatedAccount);
          },
          error: function(error) {
             console.error(error);
          }
       });
    });
    
    //驗證密碼是否正確
    $('.userPassword').on("change", function(){
    	var password = $("#pwd").val();
    	var checkPassword = $("#cpwd").val();
    	if(password != "" && checkPassword != ""){
    		if(password != checkPassword){
    			alert("請檢查密碼是否相同");
    		}
    	}
    });
    
	$('#date1').datetimepicker({
		  date:null, //一開始輸入框的日期為空
		  format: 'YYYY-MM-DD', //日期的顯示格式
		  locale: moment.locale('zh-tw'), //國別
		});
	
	 // 註冊表單提交事件監聽器
    $('form').submit(function(event) {
    	// 獲取身分的 radio 元素
        var roleRadio = $('input[name="role"]');
        var roleChecked = false;

        // 檢查是否有身分被選中
        roleRadio.each(function() {
            if ($(this).prop('checked')) {
            	roleChecked = true;
            }
        });

        // 如果没有身分被選中，阻止表單提交並提示用户
        if (!roleChecked) {
            alert('請選擇身分');
            event.preventDefault();
        }
    
        // 獲取性别的 radio 元素
        var sexRadio = $('input[name="sex"]');
        var sexChecked = false;

        // 檢查是否有性别被選中
        sexRadio.each(function() {
            if ($(this).prop('checked')) {
                sexChecked = true;
            }
        });

        // 如果没有性别被選中，阻止表單提交並提示用户
        if (!sexChecked) {
            alert('請選擇性别');
            event.preventDefault();
        }
    });
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
	padding: 15px;
	margin-top: 15px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 10px;
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

.form-group input[type="radio"] {
	margin: 10px; /* 调整间距 */
    vertical-align: middle; /* 使元素垂直居中 */
}
</style>
</head>
<body>
<div class="container">
		<h2>註冊</h2>
		<form action="${pageContext.request.contextPath}/sigIn" method="post" modelAtribute="User">
				<div class="form-group">
				<label for="no">帳號:(您的身分是?)</label>
				<input type="radio" name="role" value="T">老師
				<input type="radio" name="role" value="A" >學生
				<br/><!-- 使用 type="button" 防止提交表單 -->
 				<input type="button" id="generateAccountBtn" value="產生帳號" style="margin: 5px;">
 				<!-- 用於顯示生成的帳號 -->
   				<input type="text" class="generatedAccount" readonly>
   				<input type="hidden" class="generatedAccount" name="no">
			</div>
			<div class="form-group">
				<label for="pwd">密碼:</label>
				<input type="password" id="pwd" class="userPassword" name="pwd" required>
			</div>
			<div class="form-group">
				<label for="cpwd">確認密碼:</label>
				<input type="password" id="cpwd" class="userPassword" name="cpwd" required>
			</div>
			<div class="form-group">
				<label for="name">姓名:</label>
				<input type="text" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="mail">信箱:</label>
				<input type="text"  pattern="^\w+@\w+(\.\w+){1,2}$" title="請輸入正確的信箱格式"  id="mail" name="mail" required>
			</div>
			<div class="form-group">
				<label for="bday">生日:</label>
				<div class="input-group date" id='date1'>
					<input type="text" class="form-control" name="bday"/>
　　					<span class="input-group-addon">
　　　					<i class="glyphicon glyphicon-calendar" ></i>
					</span>
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px;">
				<label for="name" >性別:</label>
				<input type="radio" name="sex" value="1">男性
				<input type="radio" name="sex" value="0">女性
			</div>
			<div class="form-group">
				<input type="submit" value="註冊">
				<a class="btn btn-outline-dark btn-sm" href="./index.jsp" style="float: right;"><strong>返回首頁</strong></a>
			</div>
		</form>
			
	</div>
</body>
</html>