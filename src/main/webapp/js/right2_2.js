/**
 * Created by lanxing on 16-3-28.
 */
$(function(){
    ajax();
    // setInterval(getjson, 10000);
});

function  ajax(){
    $.ajax({
        url:'/lightstatus/all.do',//需要添加
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

    jsonData.sort(function (a,b) {
        if(a.deviceId==b.deviceId){
            if(a.groupId==b.groupId){
                return a.inGroupId-b.inGroupId;
            }else{
                return a.groupId-b.groupId;
            }
        }else{
            return a.deviceId-b.deviceId;
        }
    })
    // // 按任务时间排序
    // var sortBy = function (filed, rev, primer) {
    //     rev = (rev) ? -1 : 1;
    //     return function (a, b) {
    //         a = a[filed];
    //         b = b[filed];
    //         if (typeof (primer) != 'undefined') {
    //             a = primer(a);
    //             b = primer(b);
    //         }
    //         if (a < b) { return rev * -1; }
    //         if (a > b) { return rev * 1; }
    //         return 1;
    //     }
    // };
    // jsonData.sort(sortBy('inGroupId',false,String));

    $.each(jsonData, function (index,item) {
        //循环获取数据
        var id_only = item.id;
        var id = item.light.id;
        var deviceId = item.light.deviceId;
        var groupId = item.light.groupId;
        var inGroupId =item.light.inGroupId;
        var voltage = item.vol;
        var current = item.cur;
        var power = item.pow;
        var bright = item.bright;
        var enviBright = item.enviBright;
        var temperature = item.temperature;
        var temperature1 = item.temperature1;
        var temperature2 = item.temperature2;
        var infoTime = item.infoTime;
        var date =new Date(parseInt(infoTime));
        var curDate=date.toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");

        // var bright2 = Number(bright)*100/255;

        var lineObj = $("<tr style='border: 1px solid skyblue'></tr>")

        var idOnlyObj = $("<td style='display: none'></td>")
        idOnlyObj.html(id_only);

        var numObj = $("<td></td>")
        numObj.html(index + 1);

        var deviceIdObj=$("<td></td>")
        deviceIdObj.html(deviceId);

        var groupIdObj=$("<td></td>")
        groupIdObj.html(groupId);

        var inGroupIdObj=$("<td></td>")
        inGroupIdObj.html(inGroupId);

        var voltageObj=$("<td></td>")
        voltageObj.html(voltage);

        var currentObj=$("<td></td>")
        currentObj.html(current);

        var powerObj=$("<td></td>")
        powerObj.html(power);

        var brightObj=$("<td></td>")
        brightObj.html(bright);

        var enviBrightObj=$("<td></td>")
        enviBrightObj.html(enviBright);

        var temObj=$("<td></td>")
        temObj.html(temperature);

        var tem1Obj=$("<td></td>")
        tem1Obj.html(temperature1);

        var tem2Obj=$("<td></td>")
        tem2Obj.html(temperature2);

        var curDateObj =$("<td></td>")
        curDateObj.html(curDate);

        idOnlyObj.appendTo(lineObj);
        numObj.appendTo(lineObj);
        deviceIdObj.appendTo(lineObj);
        groupIdObj.appendTo(lineObj);
        inGroupIdObj.appendTo(lineObj);
        voltageObj.appendTo(lineObj);
        currentObj.appendTo(lineObj);
        powerObj.appendTo(lineObj);
        brightObj.appendTo(lineObj);
        enviBrightObj.appendTo(lineObj);
        // temObj.appendTo(lineObj);
        // tem1Obj.appendTo(lineObj);
        // tem2Obj.appendTo(lineObj);
        curDateObj.appendTo(lineObj);
        lineObj.appendTo(fatherObj);



    })


}


