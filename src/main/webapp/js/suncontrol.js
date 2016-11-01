/**
 * Created by gch on 16-5-30.
 */

    function cmd(url){
        if(window.ActiveXObject){ //如果是IE浏览器
            xmlHttpRequest= new ActiveXObject("Microsoft.XMLHTTP");
        }else if(window.XMLHttpRequest){ //非IE浏览器
            xmlHttpRequest= new XMLHttpRequest();
        }
        xmlHttpRequest.open("POST",url,true);//post光照控制指令
        xmlHttpRequest.send(null);
    }

    function suncontrol(){
        var openlimit = $("#openlimit").val();
        var closelimit = $("#closelimit").val();
        var controldays = $("#controldays").val();
        if(openlimit == ""){
            alert("请输入开灯阈值！");
        }else{
            if(closelimit == ""){
                alert("请输入关灯阈值！");
            }else{
                var url = "/control/suncontrol.do?openlimit="+openlimit+"&closelimit="+closelimit+"&controldays="+controldays;
                cmd(url);
                alert("发送命令成功！");
            }
        }

    }


