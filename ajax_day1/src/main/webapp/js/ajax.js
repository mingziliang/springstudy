function get(url,param,callback) {
    var xhr;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else{
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //b.发送请求并传递参数
    //处理param null的情况
    url = param?url+"?"+param:url;
    xhr.open("GET",url);
    xhr.send();
    xhr.onreadystatechange = function () {
        if(xhr.readyState==4&&xhr.status==200){
           // xhr.responseText;
            callback(xhr.responseText);//调用函数
        }
    }
}

function get(url,param,callback) {
    var xhr;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else{
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //b.发送请求并传递参数
    //处理param null的情况
    //url = param?url+"?"+param:url;
    xhr.open("POST",url);
    xhr.setRequestHeader("content-type","application/x-www-urlencoded");
    xhr.send(params);
    xhr.onreadystatechange = function () {
        if(xhr.readyState==4&&xhr.status==200){
            // xhr.responseText;
            callback(xhr.responseText);//调用函数
        }
    }
}