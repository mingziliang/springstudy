<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="utf-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>通过异步形式展示一个人信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                var id = 21;
                var xhr;
                if (window.XMLHttpRequest) {
                    xhr = new XMLHttpRequest();
                } else {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP")
                }
                xhr.open("GET", "${pageContext.request.contextPath}/user/findOne?id=" + id);
                xhr.send();
                xhr.onreadystatechange = function () {
                    //处理完整且正确的响应
                    if(xhr.readyState==4&&xhr.status==200){
                        console.log(xhr.responseText);//响应结果
                        var jsObj = eval("("+xhr.responseText+")");
                        console.log(jsObj);
                        var idLi = $("<li/>").text("id:"+jsObj.id);
                        var nameLi = $("<li/>").text("name:"+jsObj.name);
                        var ageLi = $("<li/>").text("age:"+jsObj.age);
                        var birLi = $("<li/>").text("bir:"+jsObj.bir);
                        $("#ul").empty().hide().append(idLi).append(nameLi).append(ageLi).append(birLi).show(3000);
                    }
                }
            });
        });
    </script>
</head>
<body>
<input type="button" id="btn" value="点我显示一个人信息 ">
<hr>
<ul id="ul"></ul>
</body>
</html>