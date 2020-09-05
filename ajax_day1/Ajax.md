# Ajax

## 1.传统请求和异步请求

- 传统请求： 基于form表单 超级连接 地址栏 location.href 等发起请求都属于传统请求     

​     特点：请求之后，刷新整张页面
​     缺点：由于刷新了整张页面 导致用户操作被中断，造成大量网络流量的极大浪费

- 异步请求：基于ajax发起的请求都是异步请求

​	特点：多个请求并行发生，请求之间互不影响，请求之后页面不懂，刷新页面的局部

## 2.什么是Ajax

```
Ajax 即“Asynchronous  Javascript And XML”（异步 JavaScript 和 XML），

Ajax 不是一种新的编程语言，而是一种用于创建更好更快以及交互性更强的Web应用程序的技术。
```



## 3.Ajax的核心对象

```
 XMLHttpRequest对象是一个javascript对象，存在着浏览器差异。简称xhr对象
```



## 4.Ajax的编程思路

```
xxxAction
private String username;
set/get 省略
public String xxx(){
	//1.收集数据
	//2.调用业务对象
	//3.响应结果
	response = ServletActionContext.getResponse();
	response.getWriter().print("ok")
	return null; //注意ajax发起的请求action中对应方法一定不能有返回值
}
```



```javascript
//1.创建xhr对象 
//目前为止： 浏览器内核webkit | ie系edge（微软）edge webkit
var xhr ;
	if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else{
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

//2.发送请求并传递参数
xh.open("GET|POST","URL？参数"); //设置请求方式和请求路径
xhr.send(null); 				//发送请求

//3.处理响应并渲染页面
//xhr.readyState
//	0 xhr没有初始化 1 xhr创建 2发送请求 3 响应回来，不完整 4完整响应
//xhr.status 
//	404 路径找不到 500 程序出错 405 service方法名 200正确响应
xhr.onreadystatechange = function(){ //处理结果
    if(xhr.readyState == 4 && xhr.state== 200){  //处理完整且正确的响应
   	 	console.log(xhr.resonseText); //xhr.resonseText用来获取action响应的字符串===》ok 
        //通过js jquery更新页面的局部
    }
}
```



## 5.发送GET方式请求

```javascript
//1.创建xhr对象
var xhr;
if(window.XMLHttpRequest){
	xhr = new XMLHttpRequest();
}else{
    xhr =  new ActiveXObject("Microsoft.XMLHTTP");
}
//2.发送请求，并传递参数
xhr.open("GET","${pageContext.request.contextPath}/ajax_day2/checkName?name=zhangsan")
xhr.send();
//3.处理响应
xhr.onreadystatechange = function(){ //处理结果
    if(xhr.readyState == 4 && xhr.state== 200){  //处理完整且正确的响应
   	 	console.log(xhr.resonseText); //xhr.resonseText用来获取action响应的字符串===》ok 
        //通过js jquery更新页面的局部
    }
}
```



## 6.发送POST方式请求

```javascript
//1.创建xhr对象
var xhr;
if(window.XMLHttpRequest){
	xhr = new XMLHttpRequest();
}else{
    xhr =  new ActiveXObject("Microsoft.XMLHTTP");
}
//2.发送请求，并传递参数
xhr.open("POST","${pageContext.request.contextPath}/ajax_day2/checkName")
xhr.setRequestHeader("content-type","application/x-www-fom-urlencoded");
xhr.send("name="+name)
//3.处理响应
xhr.onreadystatechange = function(){ //处理结果
    if(xhr.readyState == 4 && xhr.state== 200){  //处理完整且正确的响应
   	 	console.log(xhr.resonseText); //xhr.resonseText用来获取action响应的字符串===》ok 
        //通过js jquery更新页面的局部
    }
}
```



## 7.Ajax的数据交换机制

JSON(JavaScript Object Notation, JS对象标记)是一种轻量级的数据交换格式。

```java
//1.如果服务器响应的不再试字符串而是对象或者是集合类型时，无法直接将对象响应给客户端
//	如： User、List<User>、Map<String,User> 需要将对象转为格式字符串响应给ajax。

//2.如何将对象转为json格式的字符串
User user = new User("21","chenyu",23,123.0);
//String userJson = JSONObject.toJSONString(user);//fastjson json
//4.处理json字符串中的日期格式问题
String userJson = JSONObject.toJsonStringWithDataFormat(user,"yyyy-MM-dd");
reponse.setContentType("application/json;charset=UTF-8");
PrintWriter writer = repsonse.getWriter();
writer.out(userJson);
```

```javascript
//3.前端的ajax函数应该如何处理json格式的字符串
xhr.onreadystatechange = function(){ //处理结果
    if(xhr.readyState == 4 && xhr.state== 200){  //处理完整且正确的响应
        var json = xhr.reponseText;//json
        var userObj = eval("("+xhr.repsonseText+")")//转为js对象
   	 	console.log(userObj.id); 
        console.log(userObj.name);
    }
}


```



## 8.jQuery对Ajax的封装

```javascript
//1.使用jQuery对象ajax封装
//a.在对应页面中引入jQuery相关的js文件
<script src=".../js/jQuery-min.js"></script>
//b.如何使用jQuery封装ajax
1). $.ajax();    //通用可配置ajax请求  发送GET| POST请求 可配置...
	$ ===> jQuery 等价
    $.ajax({
        type: "GET|POST" GET发起GET方式请求 POST发起POST方式请求
        url:  "请求后台路径" //请求路径
        date: {}|"" //{username:"zhangsan",age:23}| "username=zhangsan&age=23"
        success: function(result){
        result; //就是当前返回的响应结果
        //如果请求的url对应返回的是一个json格式数据，jquery自动将json转为响应js对象
        //如果请求的url对应返回的是一个普通格式字符串，jquery返回的就是字符串本身
    }
    })
    
2). $.get();     //只能发起GET方式的ajax请求
	$.get(url,[data],[callback],[datatype])
		url：请求路径
    	data：请求参数可有可无
    	callback：响应回来回调函数 可有可无 function(result){result}
		dataType:定义服务器返回数据格式 text/plain "JSON"=application/json

3). $.getJSON(); //只能发起GET方式的ajax请求，只要返回数据必须是json格式数据
	$.getJSON(url,[data],[callback])
		url：请求路径
   		data：请求参数 可有可无
    	callback：响应回来回调函数 可有可无 function(result){result}
		
4). $.post();    //只能发起POST方式的ajax请求
	$.post(url,[data],[callback],[datatype])
		url：请求路径
    	data：请求参数可有可无
    	callback：响应回来回调函数 可有可无 function(result){result}
		dataType:定义服务器返回数据格式 text/plain "JSON"=application/json
```







