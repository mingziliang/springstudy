<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="utf-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>通过异步形式展示所有人信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajax.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                
            });
        });

    </script>
</head>
<body id="bd">
<input type="button" id="btn" value="点我显示所有人信息 ">
<hr color="red">
<ul id="ul"></ul>
</body>
</html>