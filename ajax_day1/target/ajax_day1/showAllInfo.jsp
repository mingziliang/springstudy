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
                var xhr;
                if (window.XMLHttpRequest) {
                    xhr = new XMLHttpRequest();
                } else {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP")
                }
                xhr.open("post", "${pageContext.request.contextPath}/user/findAll");
                xhr.setRequestHeader("context-type", "application/x-www-form-urlencoded");
                xhr.send();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        console.log(xhr.responseText);
                        var jsArr = eval("(" + xhr.responseText + ")");
                        console.log(jsArr);
                        $("ul,hr:gt(0)").remove();
                        $.each(jsArr, function (idx, user) {
                            console.log(user);
                            var ul = $("<ul/>");
                            var idLi = $("<li/>").text("id:"+user.id);
                            var nameLi = $("<li/>").html("<span style='coler:gold;'> name:"+user.name+"</span>");
                            var ageLi = $("<li/>").text("age:"+user.age);
                            var birLi = $("<li/>").text("bir:"+user.bir);
                            ul.append(idLi).append(nameLi).append(ageLi).append(birLi);
                            $("#bd").append(ul).append("<hr/>");
                        });
                    }
                }
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