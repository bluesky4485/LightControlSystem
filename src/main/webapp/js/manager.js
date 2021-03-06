/**
 * Created by gch on 16-4-14.
 */
$(function(){
    getjson();
});


function deletecmd(userId){
    $.ajax({
        url:"/user/delete.do",
        type:"POST",
        data:{
          userId:userId
        },
        dataType:'json',
        success:alert("删除成功")
    })
}

function getjson(){
    $.ajax({
        url:'/user/all.do',
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
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
            // var password = item.password;
            var phone = item.phone;
            var address = item.address;
            var authority = item.authority;


            var lineObj = $("<tr style='border: 1px solid skyblue'></tr>");

            var userIdObj = $("<td style='display: none'></td>");
            userIdObj.html(userId);

            var numObj = $("<td></td>");
            numObj.html(index + 1);

            var userNameObj=$("<td></td>");
            userNameObj.html(userName);

            // var passwordObj=$("<td></td>")
            // passwordObj.html(password);

            var phoneObj=$("<td></td>");
            phoneObj.html(phone);

            var addressObj=$("<td></td>");
            addressObj.html(address);

            var authorityObj =$("<td style='display: none'></td>");
            authorityObj.html(authority);

            var deletebutton = $("<td><button style='width: 50%'>"+"删除"+"</button></td>");
            deletebutton.children().click(function(){
                if(authority==1){
                    $(this).parent().parent().remove();
                    deletecmd(userId);
                }
            });


            userIdObj.appendTo(lineObj);
            numObj.appendTo(lineObj);
            userNameObj.appendTo(lineObj);
            // passwordObj.appendTo(lineObj);
            phoneObj.appendTo(lineObj);
            addressObj.appendTo(lineObj);
            authorityObj.appendTo(lineObj);
            deletebutton.appendTo(lineObj);

            lineObj.appendTo(fatherObj);



        })


    }
}