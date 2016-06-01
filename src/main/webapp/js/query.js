/**
 * Created by chgu1_000 on 2016/3/21.
 */
$(function(){
    $( "input[name='cha_start_time'],input[name='cha_stop_time']").datetimepicker();
})
//$(function() {
//                    $(".mys").newDatePick({isTime:false});
////    $( "input[id='cha_start_time'],input[id='cha_stop_time']").newDatePick({isTime:false});
//});

function findData(start_time,stop_time){
    $.ajax({
        url:'/control/query.do?start_time='+start_time+"&stop_time="+stop_time,//需要添加
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
    function succFunction(data) {
        $("#list").html('');
        var json = eval(data); //数组
        var fatherObj = $("#list");
        $.each(json, function (index, item) {
            var opentime = item.openTime;
            var closetime = item.closeTime;
            var infotime = item.infoTime;
            //var opendate;
            //var closedate;
            var openDate;
            var closeDate;
            if(opentime != null){
                //opendate = new Date(parseInt(opentime));
                openDate =  new Date(parseInt(opentime)).toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");
            }else{
                openDate = "/";
            }


            if(closetime!=null){
               // closedate = new Date(parseInt(closetime));
                closeDate = new Date(parseInt(closetime)).toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");
            }else{
                closeDate = "/";
            }

            var infodate = new Date(parseInt(infotime));
            var infoDate = infodate.toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");
            var username = item.user.userName;
            var bright = item.bright;


            var lineObj = $("<tr></tr>")

            var numObj = $("<td></td>")
            numObj.html(index + 1);

            var infoDateObj = $("<td></td>")
            infoDateObj.html(infoDate);

            var usernameObj = $("<td></td>")
            usernameObj.html(username);


            var openDateObj = $("<td></td>")
            openDateObj.html(openDate);

            var closeDateObj = $("<td></td>")
            closeDateObj.html(closeDate);

            var brightObj = $("<td></td>")
            brightObj.html(bright);

            numObj.appendTo(lineObj);
            infoDateObj.appendTo(lineObj);
            usernameObj.appendTo(lineObj);
            openDateObj.appendTo(lineObj);
            closeDateObj.appendTo(lineObj);
            brightObj.appendTo(lineObj);

            var devicetableObj=$("<table style='text-align: center'></table>");
            var devicecolObj=$("<td></td>");
            for(var i=0;i<item.lights.length;i++){
                var deviceId= item.lights[i].deviceId;
                var deviceIdObj=$("<tr></tr>");
                deviceIdObj.html(deviceId);
                deviceIdObj.appendTo(devicetableObj);
                devicetableObj.appendTo(devicecolObj);
                devicecolObj.appendTo(lineObj);
            }
            var grouptableObj=$("<table style='text-align: center'></table>");
            var groupcolObj=$("<td></td>");
            for(var i=0;i<item.lights.length;i++){
                var groupIdObj=$("<tr></tr>");
                var groupId = item.lights[i].groupId;
                groupIdObj.html(groupId);
                groupIdObj.appendTo(grouptableObj);
                grouptableObj.appendTo(groupcolObj);
                groupcolObj.appendTo(lineObj);

            }
            var ingrouptableObj=$("<table style='text-align: center'></table>");
            var ingroupcolObj=$("<td></td>");
            for(var i=0;i<item.lights.length;i++){
                var inGroupIdObj=$("<tr></tr>");
                var inGroupId = item.lights[i].inGroupId;
                inGroupIdObj.html(inGroupId);
                inGroupIdObj.appendTo(ingrouptableObj);
                ingrouptableObj.appendTo(ingroupcolObj);
                ingroupcolObj.appendTo(lineObj);

            }
            lineObj.appendTo(fatherObj);
        });
    }
};
