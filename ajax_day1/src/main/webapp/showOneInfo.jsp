<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="utf-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ajax GET方式请求</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script>
        $(function () {
            //1.绑定用户名失去焦点事件
            $("#username").blur(function () {
                //思路： 发送ajax请求 根据用户名验证用户名是否合法
                //1.获取用户输入值
                var username = $(this).val();
                console.log(username);
                //2.发送ajax的get方式请求
                //a.创建xhr对象
                var xhr;
                if(window.XMLHttpRequest){
                    xhr = new XMLHttpRequest();
                }else{
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                }
                //b.发送请求并传递参数
                xhr.open("GET","${pageContext.request.contextPath}/user/checkName?username="+username);
                xhr.send();
                //c.处理响应并更新页面局部
                xhr.onreadystatechange = function () {
                    //处理完整且正确的响应
                    if(xhr.readyState==4 && xhr.status==200){
                        console.log(xhr.responseText);
                        $("#msg").text(xhr.responseText);
                    }
                }
            })
        })
    </script>
</head>
<body>
<form action="">
    用户名：<input type="text" id="username"> <span id="msg"></span> <br>
</form>
</body>
</html>