<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <link href="../css/style.css" rel="stylesheet" />
    <link href="../css/jquery.range.css" rel="stylesheet" />
    <link href="../css/admin.css"  rel="stylesheet"/>
    <link href="../css/jquery-ui2.css" rel="stylesheet"  />
    <link href="../css/right2.css" rel="stylesheet"  />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/right2_2.js"></script>
    <script src="../js/right2.js"></script>
    <script src="../js/jquery/jquery.artDialog.js?skin=idialog"></script>
    <script src="../js/jquery/jquery.range.js"></script>
    <script src="../js/jquery-ui-1.10.4.custom.min.js"></script>
    <script src="../js/jquery.ui.datepicker-zh-CN.js"></script>
    <script src="../js/jquery-ui-timepicker-addon.js"></script>
    <script src="../js/jquery-ui-timepicker-zh-CN.js"></script>
</head>
<body style="text-align: center;width: 100%">
<div style="margin: 0 auto;width:95%;text-align: center;">
    <div style="margin:0 auto">
        <div class="div1">
            <div class="div1_1">
                <h4><span class="text-primary" style="text-align: center">方式选择</span></h4><br>
                <input id="controltime" class="flo1" type="radio" name="control"  checked="checked" value="1">
                <h4 class="flo1">定时控制&nbsp;</h4>
                <input id="controlnow" class="flo1" type="radio" name="control"  value="0">
                <h4 class="flo1">即时控制</h4>
            </div>
            <div class="div1_3">
                <div id="bright" class="div1_3_1">
                    <h4 class="text-primary" style="text-align: center">灯的亮度(关灯为0)</h4><br>
                    <div class="div1311">
                        <input  type="hidden" class="single-slider" />
                    </div>
                </div>
                <div id="light_time" class="div1_3_2" >
                    <h4 class="text-primary" style="text-align: center">任务时间</h4>
                    <div class="div1321">
                        <input name="act_start_time" id="act_start_time" type="text" class="text-box" value="" placeholder="开灯时间" title="开始时间≥当前时间"  style="cursor:pointer;"/>
                        <input name="act_stop_time" id="act_stop_time" type="text" class="text-box" value="" placeholder="关灯时间" title="结束时间>开始时间"  style="cursor:pointer;"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="div2">
        <div class="div2_1">
            <h4 style="text-align: center"><span class="text-primary">灯的选择</span></h4><br>
            <input id="notall" class="flo1" type="radio" name="suoyou"  value="0" checked="checked">
            <h4 class="flo1">非所有灯</h4>
            <input id="all" class="flo1" type="radio" name="suoyou" value="1" >
            <h4 class="flo1">所有的灯&nbsp;</h4>
        </div>
        <div id="choose_light" class="div2_2">
            <div class="div2_2_1">
                <div style="width: 100%">
                    <input type="text" id="jizhongtxt" style="width: 50%;"/>
                    <button   id="jizhong" class=" btn-primary" >
                        <div style="display:none" id="selectjizhong"></div>
                        选择集中选择器
                    </button>
                </div>
            </div>
            <div class="div2_2_2">
                <div style="width: 100%">
                    <input type="text" id="zutxt" style="width: 50%;"/>
                    <button   id="zu" class=" btn-primary" >
                        <div style="display:none" id="selectzu"></div>
                        选择具体组号
                    </button>
                </div>
            </div>
            <div class="div2_2_2">
                <div style="width: 100%">
                    <input type="text" id="lighttxt" style="width: 50%;"/>
                    <button   id="light" class=" btn-primary" >
                        <div style="display:none" id="selectlight"></div>
                        选择具体灯号
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="div3" >
        <button id="sub"  class=" btn-primary" ><h4>提交</h4></button>
    </div>
    <div style="float:left;width:100%;margin-top: 5px;min-width: 700px;">
        <table style="width: 100%;">
            <thead>
            <tr style="background-color: #215867;text-align: center;">
                <td><span style="color: white">#        </span></td>
                <td><span style="color: white">集中控制器</span></td>
                <td><span style="color: white">组号     </span></td>
                <td><span style="color: white">灯号     </span></td>
                <td><span style="color: white">电压(V)  </span></td>
                <td><span style="color: white">电流(A)  </span></td>
                <td><span style="color: white">功率(W)  </span></td>
                <td><span style="color: white">亮度(%)  </span></td>
                <td><span style="color: white">环境亮度  </span></td>
                <%--<td><span style="color: white">温度0    </span></td>--%>
                <%--<td><span style="color: white">温度1    </span></td>--%>
                <%--<td><span style="color: white">温度2    </span></td>--%>
                <td><span style="color: white">时间     </span></td>
            </tr>
            </thead>
            <tbody id="list" style="text-align: center">
            </tbody>
        </table>
    </div>


</div>
</body>

</html>