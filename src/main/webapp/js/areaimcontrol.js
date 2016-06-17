$(function(){
    // 选择亮度插件
    $('.single-slider').jRange({
        from: 0,
        to: 100,
        step: 1,
        scale: [0,25,50,75,100],
        format: '%s',
        width: 280,
        showLabels: true,
        showScale: true
    });

    // 控制任务发送
    function cmd(url){
        if(window.ActiveXObject){ //如果是IE浏览器
            xmlHttpRequest= new ActiveXObject("Microsoft.XMLHTTP");
        }else if(window.XMLHttpRequest){ //非IE浏览器
            xmlHttpRequest= new XMLHttpRequest();
        }
        xmlHttpRequest.open("POST",url,true);//需要改
        xmlHttpRequest.send(null);
    }


    $("#areaimControl").click(function() {
        var bright = $(".single-slider").val();
        var area = $('input:text[id=areatxt]').val();
        var url;
        
        url="/area/timelyControl.do?bright="+bright+"&areaNo="+area;
        if(confirm(" 亮度为"+bright+" 区域："+area)){
            cmd(url);
        }




    });

    getArea();
});


function getArea(){
    $.ajax({
        url:'/area/queryareas.do',
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        //beforeSend: LoadFunction, //加载执行方法
        //error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    })
}

function  succFunction(data) {

    var jsonData = eval(data);
    var areaString = "";
    var areaIdArr = new Array();

    $.each(jsonData, function (index,item) {
        var areaId = item.areaId;
        areaIdArr[index] = areaId;
    });
    /**
     * area
     */
    for(var i=0;i<areaIdArr.length;i++){
        areaString+="<input type='checkbox' name='area' value="+areaIdArr[i]+" />"+areaIdArr[i]+"&nbsp;&nbsp;&nbsp;&nbsp;";
    }
    var diaArea = $.dialog(
        {
            title:"area",
            width: 340,
            content:areaString,
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("area")
        }
    ).hide();
    $("#area").click(function () {
        diaArea.show();
    });
    $("input[name=area]").each(function(){//给所有的input绑定事件
        $(this).click(function(){
            var area=[];
            //创建空数组area
            $("input[name=area]:checked").each(function(i){area[i]=this.value});
            //将所有的选中的值存放de
            $("#areatxt").val(area.join(";"));//将数据值联合字符串给显示对象附值
        })
    });
}

