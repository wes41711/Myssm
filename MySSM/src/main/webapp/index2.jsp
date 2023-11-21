<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />


<title>Welcome MySSM</title>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>

<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

<script>
$('#date1').datetimepicker({
  date:null, //一開始輸入框的日期為空
  format: 'YYYY-MM-DD', //日期的顯示格式
  locale: moment.locale('zh-tw'), //國別
  daysOfWeekDisabled: [0, 6], //隱藏的天數0為周日6為星期六
  minDate: moment().add(1,'days'), //顯示最小天數
  maxDate: moment().add(30,'days'), //顯示最大天數，30為最大的顯示範圍為一個月為限
  disabledDates:
  [ //隱藏的日期
    moment().add(1,'days'), //前一日
    moment().add(2,'days'), //前二日
          '2021-10-10', //特別日期
          '2021-12-25'
  ]
});
</script>
</head>
<body>
	<label for="">選擇日期：</label>
	<div class="input-group date" id='date1'>

　　<input type="text" class="form-control" />

　　<span class="input-group-addon">

　　　<i class="glyphicon glyphicon-calendar"></i>

　　</span>
</body>
</html>
