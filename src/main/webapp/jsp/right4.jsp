<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <script src="../js/jquery/jquery-1.9.1.min.js"></script>
    <link href="../css/admin.css"  rel="stylesheet"/>
    <link href="../css/jquery-ui2.css" rel="stylesheet"  />
    <link href="../css/right4.css" rel="stylesheet"  />
    <script src="../js/bootstrap.js"></script>

    <script src="../js/jquery-ui-1.10.4.custom.min.js"></script>
    <script src="../js/jquery.ui.datepicker-zh-CN.js"></script>
    <script src="../js/jquery-ui-timepicker-addon.js"></script>
    <script src="../js/jquery-ui-timepicker-zh-CN.js"></script>
    <script src="../js/right4.js"></script>
</head>
<body>
<div>
    <div class="div1">
        <div class="div1_1">
            <h2 style="color: #1a8cff">操作查询</h2>
        </div>
        <div class="div1_2">
            <input  name="cha_start_time" id="cha_start_time" type="text" class="mys" value="" placeholder="开始时间"  style="cursor:pointer;"/>
            <input  name="cha_stop_time" id="cha_stop_time" type="text" class="mys" value="" placeholder="结束时间"  style="cursor:pointer;"/>
            &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查询" onclick="findData(document.getElementById('cha_start_time').value,document.getElementById('cha_stop_time').value)"/>
        </div>

    </div>
    <div class="div2">
        <table class="table1">
            <thead>
            <tr>
                <td rowspan="2" class="td1">#</td>
                <td rowspan="2" class="td1">操作时间</td>
                <td rowspan="2" class="td1">操作员</td>
                <td rowspan="2" class="td1">开灯时间</td>
                <td rowspan="2" class="td1">关灯时间</td>
                <td rowspan="2" class="td1">亮度</td>
                <td colspan="3" class="td1">灯</td>
            </tr>
            <tr>
                <td class="td1">集中控制器</td>
                <td class="td1">组号</td>
                <td class="td1">灯号</td>
            </tr>

            </thead>
            <tbody id="list" >
            </tbody>
        </table>
    </div>
</div>
</body>
</html>