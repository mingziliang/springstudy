<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>展示用户评论信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js">
    </script>
    <script>
        $(function () {
            //绑定评论按钮单击事件
            $("#btn").click(function () {
                //获取评论内容
                var msg = $("#msg").val();
                console.log(msg);
                //发送ajax请求
                $.getJSON("${pageContext.request.contextPath}/msg/save", {"msg.msg": msg}, function (result) {
                    if (result.status) {
                        $("#msg").val("");
                        alert(result.msg + ",点击确认更行评论区")
                        $.get("${pageContext.request.contextPath}/msg/findAll",function (result) {
                            $("#ul").empty();
                            $.each(result,function (index,msg) {
                                console.log(msg);
                                var li = $("<li/>").html("<div style='width: 500px;color: red;float: left'>"+msg.msg +"</div> &nbsp;&nbsp; <a href=''>点我支持</a>&nbsp;&nbsp;票数：" + msg.upcounts);
                                $("#ul").append(li);
                            })
                        },"JSON")
                    } else {
                        alert("评论失败：" + result.msg)
                    }
                });get
            });
            $.get("${pageContext.request.contextPath}/msg/findAll",function (result) {
                $("#ul").empty();
                $.each(result,function (index,msg) {
                    console.log(msg);
                    var li = $("<li/>").html("<div style='width: 500px;color: red;float: left'>"+msg.msg +"</div> &nbsp;&nbsp; <a href=''>点我支持</a>&nbsp;&nbsp;票数：" + msg.upcounts);
                    $("#ul").append(li);
                })
            },"JSON")
        })
    </script>
</head>
<body>

<h1>欢迎：小陈</h1>
<hr color="red">
<img src="${pageContext.request.contextPath}/imgs/1.jpg" style="width: 300px;" alt=""><br>
<hr color="red">
<form action="">
    输入评论<input type="text" id="msg" name="msg"> <input type="button" id="btn" value="添加评论">
</form>
<hr color="red">
<ul id="ul">
    <%-- <li>评论内容：这位小姐姐真好看<a href="">点击支持</a>当前票数：23</li>--%>
</ul>
</body>
</html>