/**
 * Created by chgu1_000 on 2016/3/17.
 */
function cmd(url){
    if(window.ActiveXObject){ //如果是IE浏览器
        xmlHttpRequest= new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){ //非IE浏览器
        xmlHttpRequest= new XMLHttpRequest();
    }
    xmlHttpRequest.open("POST",url,true);//需要改
    xmlHttpRequest.send(null);
};



$(document).ready(function(){
    //选择组号
    var chtm= "";
    for (var i = 1; i < 10; i++) {
        chtm += "<div style='word-wrap:break-word; width:450px; '>";
        chtm += '<label style="float:left;padding:15px"><input type="checkbox" name="aa" value="'+"0"+i+'" class="{required:true}" />' +
            '<span style="margin-left:10px">组'+i+'</span></label>';
        chtm += "</div>";
    }
    //把得到字符串利用jquery添加到元素里面生成checkbox
    $("#selectlxr").html(chtm);
    var dia = $.dialog(
        {
            title:"选择组号",width: "500px",
            content: $("#selectlxr").html(),
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("jieshouren")
        }
    ).hide();
    $("#jieshouren").click(function () {
        dia.show();
    })
    $("input[name=aa]").each(function(){//给所有的input绑定事件
        $(this).click(function(){
            var I=[];
            //创建空数组I
            $("input[name=aa]:checked").each(function(i){I[i]=this.value});
            //将所有的选中的值存放I
            $("#jsrtxt").val(I.join(";"));//将数据值联合字符串给显示对象附值
        })
    })



    //选择灯号
    var chtm2 = "";
    for (var i = 1; i < 5; i++) {
        chtm2 += "<div style='word-wrap:break-word; width:450px; '>";
        chtm2 += '<label style="float:left;padding:15px"><input type="checkbox" name="bb" value="'+i+'" class="{required:true}" />' +
            '<span style="margin-left:10px">灯'+i+'</span></label>';
        chtm2 += "</div>";
    }

    //把得到字符串利用jquery添加到元素里面生成checkbox
    $("#selectlxr2").html(chtm2);
    //创建一个 dialog弹出框
    var dia2 = $.dialog(
        {
            title:"选择灯号",width: "500px",
            content: $("#selectlxr2").html(),
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("jieshouren2")
        }
    ).hide();
    $("#jieshouren2").click(function () {
        dia2.show();
    })
    $("input[name=bb]").each(function(){//给所有的input绑定事件
        $(this).click(function(){
            var I2=[];
            //创建空数组I2
            $("input[name=bb]:checked").each(function(i){I2[i]=this.value});
            //将所有的选中的值存放I2
            $("#jsrtxt2").val(I2.join(";"));//将数据值联合字符串给显示对象附值
        })
    })


    //选择集中选择器
    var chtm3 = "";
    for (var i = 1; i < 10; i++) {
        chtm3 += "<div style='word-wrap:break-word; width:450px; '>";
        chtm3 += '<label style="float:left;padding:15px"><input type="radio" name="cc" value="'+"000"+i+'" class="{required:true}" />' +
            '<span style="margin-left:10px">集中'+i+'</span></label>';
        chtm3 += "</div>";
    }
    //把得到字符串利用jquery添加到元素里面生成checkbox
    $("#selectlxr3").html(chtm3);
    //创建一个 dialog弹出框
    var dia3 = $.dialog(
        {
            title:"选择组号",width: "500px",
            content: $("#selectlxr3").html(),
            close: function () {
                this.hide();
                return false;
            },
            follow: document.getElementById("jieshouren3")
        }
    ).hide();
    $("#jieshouren3").click(function () {
        dia3.show();
    })
    $("input[name=cc]").each(function(){//给所有的input绑定事件
        $(this).click(function(){
            var I3=[];
            //创建空数组I3
            $("input[name=cc]:checked").each(function(i){I3[i]=this.value});
            //将所有的选中的值存放I3
            $("#jsrtxt3").val(I3.join(";"));//将数据值联合字符串给显示对象附值
        })
    })



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
    //$('.range-slider').jRange({
    //    from: 0,
    //    to: 255,
    //    step: 1,
    //    scale: [0,51,102,153,204,255],
    //    format: '%s',
    //    width: 300,
    //    showLabels: true,
    //    isRange : true
    //});

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

    //$("#openlight").click(function(){
    //    $('div#bright').show();
    //});
    //
    //$("#closelight").click(function(){
    //    $('div#bright').hide();
    //});

    $(document).ready(function(){
        $(".flip2").click(function(){
            $(".panel2").slideToggle("slow");
        });
    });





})




