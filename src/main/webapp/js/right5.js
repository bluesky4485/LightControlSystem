/**
 * Created by biny on 16-5-17.
 */
$(function(){
    ajax();
    // setInterval(getjson, 10000);
});

function  ajax(){
    $.ajax({
        url:'/control/querylights.do',//需要添加
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        //beforeSend: LoadFunction, //加载执行方法
        //error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    })
}

function succFunction(tt) {
    $("#list").html('');
    var jsonData = eval(tt);
    var fatherObj = $("#list");

    // jsonData.sort(function (a,b) {
    //     if(a.deviceId==b.deviceId){
    //         if(a.groupId==b.groupId){
    //             return a.inGroupId-b.inGroupId;
    //         }else{
    //             return a.groupId-b.groupId;
    //         }
    //     }else{
    //         return a.deviceId-b.deviceId;
    //     }
    // })

    $.each(jsonData, function (index,item) {
        //循环获取数据
        var id_only = item.id;
        var deviceId = item.deviceId;
        var groupId = item.groupId;
        var inGroupId =item.inGroupId;


        var lineObj = $("<tr style='border: 1px solid skyblue;height: 30px;'  ></tr>")

        var checkboxObj = $("<td><input type='checkbox' name='split'/></td>")


        var idOnlyObj = $("<td></td>")
        idOnlyObj.html(id_only);

        var deviceIdObj=$("<td></td>")
        deviceIdObj.html(deviceId);

        var groupIdObj=$("<td></td>")
        groupIdObj.html(groupId);

        var inGroupIdObj=$("<td></td>")
        inGroupIdObj.html(inGroupId);


        checkboxObj.appendTo(lineObj);
        idOnlyObj.appendTo(lineObj);
        deviceIdObj.appendTo(lineObj);
        groupIdObj.appendTo(lineObj);
        inGroupIdObj.appendTo(lineObj);

        lineObj.appendTo(fatherObj);



    })


}



