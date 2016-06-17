<%--
  Created by IntelliJ IDEA.
  User: gch
  Date: 16-6-17
  Time: 下午1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>区域定时控制</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>

    <link href="../css/jquery.datetimepicker.css" rel="stylesheet" />
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery.datetimepicker.full.js"></script>

    <link href="../css/jquery.range.css" rel="stylesheet" />
    <script src="../js/jquery/jquery.range.js"></script>

    <link href="../css/style.css" rel="stylesheet" />
    <link href="../css/admin.css"  rel="stylesheet"/>
    <link href="../css/jquery-ui2.css" rel="stylesheet"  />
    <script src="../js/jquery/jquery.artDialog.js?skin=idialog"></script>

    <script src="../js/areatimecontrol.js"></script>
</head>
<body style="text-align: center">
<hr style="border: 1px forestgreen solid"/>
<div class="row">
    <div class="col-xs-4 col-xs-offset-4" style="border: 1px solid forestgreen;">
        <h4 class="text-primary" style="text-align: center">灯的亮度</h4><br>
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1">
                <input  type="hidden" class="single-slider" />
            </div>
        </div><br><br>
    </div>
</div>
<div class="row">
    <div class="col-xs-4 col-xs-offset-4" style="border: 1px solid forestgreen;">
        <h4 class="text-primary" style="text-align: center">任务时间</h4><br>
        <div class="row">
            <div class="col-xs-12" >
                <input name="act_start_time" id="act_start_time" type="text"  value="" placeholder="开灯时间" style="cursor: pointer;"/>
                <input name="act_stop_time"  id="act_stop_time"  type="text"  value="" placeholder="关灯时间"  style="cursor: pointer;"/>
                <input name="controldays"    id="controldays"    type="text"  value="" placeholder="控制天数，默认永久(0)" style="cursor: pointer;"/>
            </div>
        </div><br>
    </div>
</div>
<div class="row">
    <div class="col-xs-4 col-xs-offset-4" style="border: 1px solid forestgreen;">
        <h4 class="text-primary" style="text-align: center">区域选择</h4><br>
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1">
                <input type="text" id="areatxt" style="width: 50%;"/>
                <button   id="area" class=" btn-success" >
                    <div style="display:none" id="selectarea"></div>
                    选择区域
                </button>
            </div>
        </div><br>
    </div>
</div><br>
<div class="row">
    <div class="col-xs-12">
        <input type="button" class="btn btn-success active" id="areatimeControl" value="控制" >
    </div>
</div>

</body>
</html>
