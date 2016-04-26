/**
 * Created by gch on 16-4-14.
 */
$(function(){
    getjson();
    setInterval(getjson, 5000);
});

function createXmlHttpRequest(){
    if(window.ActiveXObject){ //如果是IE浏览器
        return new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){ //非IE浏览器
        return new XMLHttpRequest();
    }
}


function deletecmd(userId){
    var xmlHttpRequest = createXmlHttpRequest();
    xmlHttpRequest.open("POST","/user/delete.do?userId="+userId,true);//需要改
    xmlHttpRequest.send(null);

}

function getjson(){
    $.ajax({
        url:'/user/all.do',//需要添加
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    })
    function LoadFunction() {
        $("#list").html('加载中...');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(tt) {
        $("#list").html('');
        var jsonData = eval(tt);
        var fatherObj = $("#list");
        $.each(jsonData, function (index,item) {
            //循环获取数据
            var userId = item.userId;
            var userName = item.userName;
            var password = item.password;
            var phone = item.phone;
            var address = item.address;


            var lineObj = $("<tr style='border: 1px solid skyblue'></tr>")

            var userIdObj = $("<td style='display: none'></td>")
            userIdObj.html(userId);

            var numObj = $("<td></td>")
            numObj.html(index + 1);

            var userNameObj=$("<td></td>")
            userNameObj.html(userName);

            var passwordObj=$("<td></td>")
            passwordObj.html(password);

            var phoneObj=$("<td></td>")
            phoneObj.html(phone);

            var addressObj=$("<td></td>")
            addressObj.html(address);

            var deletebutton = $("<td><button>"+"删除"+"</button></td>")
            deletebutton.click(function(event){
                deletecmd(userId);
            })

            //var changebutton = $("<td><button>"+"修改"+"</button></td>")
            //changebutton.click(function(event){
            //    changecmd(userId);
            //})

            userIdObj.appendTo(lineObj);
            numObj.appendTo(lineObj);
            userNameObj.appendTo(lineObj);
            passwordObj.appendTo(lineObj);
            phoneObj.appendTo(lineObj);
            //addressObj.appendTo(lineObj);
            deletebutton.appendTo(lineObj);
            //changebutton.appendTo(lineObj);

            lineObj.appendTo(fatherObj);



        })


    }
}