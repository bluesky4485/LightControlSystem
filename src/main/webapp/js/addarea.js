/**
 * Created by biny on 16-5-18.
 */

function checkform(form){
    var areaid = document.getElementById("areaid").value;
    var areaname = document.getElementById("areaname").value;
    var lights = document.getElementById("lights").value();

    if( areaid == ""  ){
        alert("区域编码不能为空");
        form.areaid.focus();
        return false;
    }
    if( areaname == ""  ) {
        alert("区域名称不能为空");
        form.areaname.focus();
        return false;
    }
    if( lights == ""  ) {
        alert("灯号不能为空");
        form.lights.focus();
        return false;
    }
    return ture;

}
//$(function() {
//    function cmd(url){
//        if(window.ActiveXObject){ //如果是IE浏览器
//            xmlHttpRequest= new ActiveXObject("Microsoft.XMLHTTP");
//        }else if(window.XMLHttpRequest){ //非IE浏览器
//            xmlHttpRequest= new XMLHttpRequest();
//        }
//        xmlHttpRequest.open("POST",url,true);
//        xmlHttpRequest.send(null);
//    }
//
//    $('#addArea').click(function() {
//        var areaId = $("#areaid").val();
//        var areaName = $("#areaname").val();
//        var lights = $("#lights").val();
//        var url;
//        if( areaId ==""  ){
//            alert("区域编号不能为空");
//        }else{
//            if( areaName == ""  ){
//                alert("区域名不能为空");
//            }else{
//                    url = "/area/addarea.do?areaid="+areaId+"&areaname="+areaName+"&lights="+lights;
//                    cmd(url);
//            }
//        }
//
//    })
//})

