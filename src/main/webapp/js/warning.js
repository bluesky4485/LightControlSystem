/**
 * Created by chgu1_000 on 2016/3/23.
 */
function confirmall(){
    var col = document.getElementById("tab").rows.length;
    for(var i=1;i<col;i++){
        var value = $("#tab").find("tr").eq(i).find("td").eq(0).text();
        cmd(value);
        setTimeout(getjson(),800);
    }
    //alert("已全部确认");
}

$(function(){
    getjson();
    // setInterval(getjson, 500);
});

function createXmlHttpRequest(){
    if(window.ActiveXObject){ //如果是IE浏览器
        return new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){ //非IE浏览器
        return new XMLHttpRequest();
    }
}


function cmd(id_only){
    var xmlHttpRequest = createXmlHttpRequest();
    xmlHttpRequest.open("POST","/warning/confirm.do?id_only="+id_only,true);//需要改
    xmlHttpRequest.send(null);

}



function getjson(){
    $.ajax({
        url:'/warning/all.do',//需要添加
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        //beforeSend: LoadFunction, //加载执行方法
        //error: erryFunction,  //错误执行方法
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
        var jsondata = eval(tt);
        var fatherObj = $("#list");
        $.each(jsondata, function (index,item) {
            //循环获取数据
            var id_only = item.id;
            var id = item.light.id;
            var deviceId = item.light.deviceId;
            var groupId = item.light.groupId;
            var inGroupId =item.light.inGroupId ;
            var info = item.info;
            var status = item.status;
            var infotime = item.infoTime;
            var date =new Date(parseInt(infotime));
            var curDate=date.toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");

            var ss="N";
            if(status==1){
                ss="Y";
            }else{
                ss="N";
            }

            var lineObj = $("<tr style='border: 1px solid skyblue'></tr>");

            var idOnlyObj = $("<td style='display: none'></td>");
            idOnlyObj.html(id_only);

            var numObj = $("<td></td>")
            numObj.html(index + 1)

            var deviceIdObj=$("<td></td>")
            deviceIdObj.html(deviceId);

            var groupIdObj=$("<td></td>")
            groupIdObj.html(groupId);

            var inGroupIdOBj=$("<td></td>")
            inGroupIdOBj.html(inGroupId);

            var infObj=$("<td></td>")
            infObj.html(info);

            var statusObj=$("<td></td>")
            statusObj.html(ss);

            var curDateObj =$("<td></td>")
            curDateObj.html(curDate);

            var button = $("<td><button>"+"确认"+"</button></td>")
            button.click(function(event){
                cmd(id_only);
                setTimeout(getjson(),1000);
            })
            if( status == 0){
                idOnlyObj.appendTo(lineObj);
                numObj.appendTo(lineObj);
                deviceIdObj.appendTo(lineObj);
                groupIdObj.appendTo(lineObj);
                inGroupIdOBj.appendTo(lineObj);
                infObj.appendTo(lineObj);
                statusObj.appendTo(lineObj);
                curDateObj.appendTo(lineObj);
                button.appendTo(lineObj);
                lineObj.appendTo(fatherObj);
            }

        });
    }
}