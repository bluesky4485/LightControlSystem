/**
 * Created by gch on 16-5-30.
 */
$(function() {

    function succFunction(data) {
        var jsonData = eval(data);
        var longitudesum=0;
        var latitudesum=0;
        $.each(jsonData, function (index,item) {
            //循环获取数据
            var longitude = item.longitude;
            var latitude = item.latitude;
            longitudesum += longitude;
            latitudesum += latitude;
        })
        var longitudeavr = longitudesum/jsonData.length;
        var latitudeavr = latitudesum/jsonData.length;
        document.getElementById("longitude").value=longitudeavr;
        document.getElementById("latitude").value=latitudeavr;

    }

    function cmd(url){
        if(window.ActiveXObject){ //如果是IE浏览器
            xmlHttpRequest= new ActiveXObject("Microsoft.XMLHTTP");
        }else if(window.XMLHttpRequest){ //非IE浏览器
            xmlHttpRequest= new XMLHttpRequest();
        }
        xmlHttpRequest.open("POST",url,true);//post光照控制指令
        xmlHttpRequest.send(null);
    }

    $("#auto").click(function () {
        $.ajax({
            url:'/lightstatus/getsite.do',//需要添加
            type:"GET",
            dataType: 'json',
            timeout: 1000,
            cache: false,
            //beforeSend: LoadFunction, //加载执行方法
            //error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        })


    });

    $("#manual").click(function () {
        document.getElementById("longitude").value="";
        document.getElementById("latitude").value="";
    });

    $("#siteControl").click(function(){
        var longitude = $("#longitude").val();
        var latitude = $("#latitude").val();
        var controldays = $("#controldays").val();
        if(longitude==""){
            alert("请输入经度！");
        }else{
            if(latitude==""){
                alert("请输入纬度！");
            }else{
                var url="/control/sitecontrol.do?longitude="+longitude+"&latitude="+latitude+"&controldays="+controldays;
                cmd(url);
                alert("发送命令成功！");
            }
        }

    })

})