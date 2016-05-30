/**
 * Created by gch on 16-5-30.
 */
$(function() {

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
        document.getElementById("longitude").value=2;
        document.getElementById("latitude").value=4;
    });

    $("#manual").click(function () {
        document.getElementById("longitude").value="";
        document.getElementById("latitude").value="";
    });

    $("#sitecontrol").click(function(){
        var longitude = $("#longitude").val();
        var latitude = $("#latitude").val();
        var controldays = $("#controldays").val();
        var url="/control/sitecontrol.do?longitude="+longitude+"&latitude="+latitude+"&controldays="+controldays;
        cmd(url);
    })

})