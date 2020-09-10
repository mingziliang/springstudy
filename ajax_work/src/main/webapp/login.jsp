<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script>
        $(function () {
           //点击更换验证码
           $("#img").click(function () {
               $(this).attr("src","${pageContext.request.contextPath}/user/getImage="+Math.random());
           });
           $("#inputForm").submit(function () {
               //获取用户名
               var username=$("#username").val();
               //获取用户输入密码
               var password=$("#password").val();
               //获取验证码
               var code=$("#code").val();
               //发送ajax请求
               $.post("${pageContext.request.contextPath}/user/login",
                   {"user.username":username,"user.password":password,"code":code},
                   function (result) {
                       if(result.status){
                            alert(result.msg+",点击确定进入主页");
                            location.href="${pageContext.request.contextPath}/showAllMessage.jsp";
                       }else{
                           alert("登录错误"+result.msg);
                       }
                   });

               console.log(username+" "+password+" "+code);
               return false;//阻止表单的提交动作
           })
        });
    </script>
</head>
<body>
<form action="" id="inputForm" method="post">
    用户名：<input type="text" id="username" name="username"><br/>
    密码：<input type="text" id="password" name="password"><br/>
    验证码：<input type="text" id="code" name="code"><img id="img" src="${pageContext.request.contextPath}/user/getImage" alt=""> <br/>
    <input type="submit" value="提交">
</form>

</body>
</html>