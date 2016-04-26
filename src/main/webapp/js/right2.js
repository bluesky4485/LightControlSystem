
/**
 * Created by chgu1_000 on 2016/3/17.
 */


$(function(){

    
    // 选择亮度插件
    $('.single-slider').jRange({
        from: 0,
        to: 100,
        step: 1,
        scale: [0,25,50,75,100],
        format: '%s',
        width: 300,
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


    $("#sub").click(function() {
        var control = $('input:radio[name=control]:checked').val();//即时：0  定时：1
        //var switch1 = $('input:radio[name=switch1]:checked').val();//开灯：1
        var bright = $(".single-slider").val();
        var open_time= $('input:text[name=act_start_time]').val();
        var close_time= $('input:text[name=act_stop_time]').val();
        var all=$('input:radio[name=suoyou]:checked').val();//所有：1
        var num_jizhong = $('input:text[id=jsrtxt3]').val();
        var num_zu = $('input:text[id=jsrtxt]').val();
        var num_deng = $('input:text[id=jsrtxt2]').val();
        var url;
        if(control==0){              //即时控制
            if(all==1){           //所有的灯
                url="/control/timelyall.do?bright="+bright;
                if(confirm("所有灯亮度为"+bright)){
                    cmd(url);
                }
            }else{                //非所有的灯
                if(num_jizhong==""){
                    alert("请选择需要控制的灯");
                }else{
                        url="/control/timelygroup.do?device_no="+num_jizhong+"&group_no="+num_zu+"&deng_no="+num_deng+"&bright="+bright;
                        if(confirm("device_no="+num_jizhong+" group_no="+num_zu+" deng_no="+num_deng+" 亮度为"+bright)){
                            cmd(url);
                        }
                    }
                }
        }else{                    //定时控制
            if(all==1){            //所有灯
                    if(open_time==""&&close_time==""){
                        alert("请选择时间！");
                    }else{
                        if(open_time==""){
                            bright=0;
                            url="/control/timergroup.do?bright="+bright+"&open_time="+open_time+"&close_time="+close_time;
                            if(confirm("所有灯关灯时间："+close_time+" 亮度为"+bright+"con"+control)){
                                cmd(url);
                            }
                        }else{
                            if(bright==0) {
                                alert("请选择亮度！");
                            }else{
                                url="/control/timergroup.do?bright="+bright+"&open_time="+open_time+"&close_time="+close_time;
                                if(confirm("所有灯开灯时间："+open_time+" 关灯时间："+close_time+" 亮度为"+bright)){
                                    cmd(url);
                                }
                            }
                        }

                    }
            }else{          //非所有灯
                    if(open_time==""&&close_time==""){
                        alert("请选择时间！");
                    }else{
                        if(open_time==""){
                            bright=0;
                            if(num_jizhong==""){
                                alert("请选择需要控制的灯");
                            }else{
                                url="/control/timergroup.do?device_no="+num_jizhong+"&group_no="+num_zu+"&deng_no="+num_deng+"&bright="+bright+"&open_time="+open_time+"&close_time="+close_time;
                                if(confirm("开灯："+open_time+" 关灯："+close_time+" device_no="+num_jizhong+" group_no="+num_zu+" deng_no="+num_deng+" 亮度为"+bright)){
                                    cmd(url);
                                }
                            }
                        }
                        else{
                            if(bright==0) {
                                alert("请选择亮度！");
                            }else{
                                if(num_jizhong==""){
                                    alert("请选择需要控制的灯");
                                }else{
                                    url="/control/timergroup.do?device_no="+num_jizhong+"&group_no="+num_zu+"&deng_no="+num_deng+"&bright="+bright+"&open_time="+open_time+"&close_time="+close_time;
                                    if(confirm("开灯："+open_time+" 关灯："+close_time+" device_no="+num_jizhong+" group_no="+num_zu+" deng_no="+num_deng+" 亮度为"+bright)){
                                        cmd(url);
                                    }
                                }
                            }
                        }
                    }
            }
        }
    });

    $( "input[name='act_start_time'],input[name='act_stop_time']" ).datetimepicker();

    $("#controlnow").click(function(){
        $('div#light_time').fadeOut();
        //}
        //, function (){
        //    $('div#switch').fadeIn();
        });

    $("#controltime").click(function(){
        $('div#light_time').fadeIn();
        //}
        //, function (){
        //$('div#switch').fadeOut();
        });

    $("#all").click(function(){
        $('div#choose_light').hide();
    });
    

    $("#notall").click(function(){
        $('div#choose_light').show();
    });


    $(document).ready(function(){
        $(".flip2").click(function(){
            $(".panel2").slideToggle("slow");
        });
    });



    ajax2();





});


function ajax2(){
    $.ajax({
        url:'/control/querylights.do',
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        //beforeSend: LoadFunction, //加载执行方法
        //error: erryFunction,  //错误执行方法
        success: succFunction2 //成功执行方法
    })
}

function  succFunction2(data) {

    var jsonData = eval(data);

    var deviceString = "";
    var groupString = "";
    var inGroupString = "";

    var deviceIdArr = new Array();
    var groupIdArr = new Array();
    var inGroupIdArr = new Array();


    $.each(jsonData, function (index,item) {
        var deviceId = item.deviceId;
        var groupId = item.groupId;
        var inGroupId = item.inGroupId;

        deviceIdArr[index] = deviceId;
        groupIdArr[index] = groupId;
        inGroupIdArr[index] = inGroupId;


    });

    /**
     * 集中控制器
     */
    //数组删除重复元素
    for(var j=0;j<deviceIdArr.length;j++){
        for(var f=j+1;f<deviceIdArr.length;f++){
            if(deviceIdArr[j]==deviceIdArr[f]){
                deviceIdArr.splice(j,1);
                j--;
                break;
            }
        }
    }
    //数组排序
    deviceIdArr.sort();

    for(var i=0;i<deviceIdArr.length;i++){
        deviceString+="<input type='radio' name='device' value="+deviceIdArr[i]+" />"+deviceIdArr[i];
    }

    var diajiz = $.dialog(
        {
            title:"集中控制器",
            width: "500px",
            // height:"300px",
            content:deviceString,
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("jizhong")
        }
    ).hide();

    $("#jizhong").click(function () {
        diajiz.show();
    });

    $("input[name=device]").each(function(){//给所有的input绑定事件
            $(this).click(function(){
                var de=[];
                //创建空数组de
                $("input[name=device]:checked").each(function(i){de[i]=this.value});
                //将所有的选中的值存放de
                $("#jizhongtxt").val(de.join(";"));//将数据值联合字符串给显示对象附值
            })
    });


    /**
     * 组号
     */
    //数组删除重复元素
    for(var j=0;j<groupIdArr.length;j++){
        for(var f=j+1;f<groupIdArr.length;f++){
            if(groupIdArr[j]==groupIdArr[f]){
                groupIdArr.splice(j,1);
                j--;
                break;
            }
        }
    }
    //数组排序
    groupIdArr.sort();

    for(var i=0;i<groupIdArr.length;i++){
        groupString+="<input type='checkbox' name='group' value="+groupIdArr[i]+" />"+groupIdArr[i];
    }

    var diazu = $.dialog(
        {
            title:"组",
            width: "500px",
            // height:"300px",
            content:groupString,
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("zu")
        }
    ).hide();

    $("#zu").click(function () {
        diazu.show();
    });

    $("input[name=group]").each(function(){//给所有的input绑定事件
        $(this).click(function(){
            var zu=[];
            //创建空数组
            $("input[name=group]:checked").each(function(i){zu[i]=this.value});
            //将所有的选中的值存放
            $("#zutxt").val(zu.join(";"));//将数据值联合字符串给显示对象附值
        })
    });

    /**
     * 组内灯
     */
    //数组删除重复元素
    for(var j=0;j<inGroupIdArr.length;j++){
        for(var f=j+1;f<inGroupIdArr.length;f++){
            if(inGroupIdArr[j]==inGroupIdArr[f]){
                inGroupIdArr.splice(j,1);
                j--;
                break;
            }
        }
    }
    //数组排序
    inGroupIdArr.sort();

    for(var i=0;i<inGroupIdArr.length;i++){
        inGroupString+="<input type='checkbox' name='light' value="+inGroupIdArr[i]+" />"+inGroupIdArr[i];
    }

    var dialight = $.dialog(
        {
            title:"组",
            width: "500px",
            // height:"300px",
            content:inGroupString,
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("light")
        }
    ).hide();

    $("#light").click(function () {
        dialight.show();
    });

    $("input[name=light]").each(function(){//给所有的input绑定事件
        $(this).click(function(){
            var light=[];
            //创建空数组
            $("input[name=light]:checked").each(function(i){light[i]=this.value});
            //将所有的选中的值存放
            $("#lighttxt").val(light.join(";"));//将数据值联合字符串给显示对象附值
        })
    })
}

