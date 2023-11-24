<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
        rel="stylesheet" />
    <title>bookSystem</title>
    <base target="_self" />
    <link rel="icon" href="./favicon.ico" />
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <script language="javascript">
        $(function () {
            $(document).ready(function () {
                $("#goBackBtn").click(function () {
                    window.history.back();
                });

                $('#date1').datetimepicker({
                    date: null, //一開始輸入框的日期為空
                    format: 'YYYY-MM-DD', //日期的顯示格式
                    locale: moment.locale('zh-tw'), //國別
                    daysOfWeekDisabled: [0, 6], //隱藏的天數0為周日6為星期六
                    minDate: moment().add(1, 'days'), //顯示最小天數
                    maxDate: moment().add(30, 'days'), //顯示最大天數，30為最大的顯示範圍為一個月為限
                    disabledDates: [
                        //隱藏的日期
                        moment().add(1, 'days'), //前一日
                        moment().add(2, 'days'), //前二日
                        '2021-10-10', //特別日期
                        '2021-12-25'
                    ]
                });

                // 註冊表單提交事件監聽器
                $('form').submit(function (event) {
                    // 獲取書號的 checkbox 元素
                    var bookCheckboxes = $('input[name="bookId"]');
                    var bookIdChecked = false;

                    // 檢查是否有書被選中
                    bookCheckboxes.each(function () {
                        if ($(this).prop('checked')) {
                            bookIdChecked = true;
                        }
                    });

                    // 如果没有書被選中，阻止表單提交並提示用户
                    if (!bookIdChecked) {
                        alert('請至少選擇一本書');
                        event.preventDefault();
                    }
                });
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

        .textbody h1 {
            font-size: 50px;
            letter-spacing: 1.5px;
            text-align: center; /* 將文字置中 */
        }

        .infoBody {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        table {
            width: 700px;
            margin-bottom: 10px;
        }

        tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
            font-size: 20px; /* 調整字體大小 */
             text-align: center; /* 將文字置中 */
        }

        .col-md-3 {
            text-align: center; /* 將文字置中 */
        }

        .form-group {
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center; /* 將文字置中 */
        }

        input[type="submit"] {
            margin-top: 15px;
        }
    </style>
</head>

<body>
    <div class="textbody">
        <h1>歡迎'${name}'進入圖書系統</h1>
        <button class="btn btn-primary" id="goBackBtn"><strong>返回個人頁</strong></button>
    </div>
    <form action="${pageContext.request.contextPath}/appointment" method="post">
        <div class="infoBody">
            <table>
                <thead>
                    <tr>
                        <th>預借</th>
                        <th>書號</th>
                        <th>書名</th>
                        <th>庫存數量</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td><input type="checkbox" name="bookId" value="${book.bookId}"></td>
                            <td>${book.bookId}</td>
                            <td>${book.bName}</td>
                            <td>${book.bNumber}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="form-group">
            <div class="col-md-3">
                <h4>預約日期</h4>
                <div class="input-group date" id='date1'>
                    <input type="text" class="form-control" name="bday" required />
                    <span class="input-group-addon">
                        <i class="glyphicon glyphicon-calendar"></i>
                    </span>
                </div>
            </div>
            <input type="submit" class="btn btn-primary" value="預借">
        </div>
    </form>
</body>

</html>