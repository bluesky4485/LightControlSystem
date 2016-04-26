<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en" xmlns:http="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>警情处理</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <link href="../css/right3.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/right3.js"></script>
</head>
<script>
    function confirmall(){
        var col = document.getElementById("tab").rows.length;
        for(var i=1;i<col;i++){
            var value = $("#tab").find("tr").eq(i).find("td").eq(0).text();
            cmd(value);
        }
        alert("已全部确认");
    }
</script>
<body style="text-align: center;width: 100%">
<div style="margin: 0 auto;width: 70%">
    <div class="div1">
        <table class="table1" id="tab">
            <thead style="text-align: center">
            <tr class="tr1">
                <td><span class="text-primary"><h5>警情处理</h5></span></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><input type="button" value="全部确认" onclick="confirmall()"/></td>
            </tr>
            <tr class="tr2">
                <td><span style="color: white">#</span></td>
                <td><span style="color: white">控制器</span></td>
                <td><span style="color: white">具体组号</span></td>
                <td><span style="color: white">具体灯号</span></td>
                <td><span style="color: white">警情原因</span></td>
                <td><span style="color: white">已处理(Y/N)</span></td>
                <td><span style="color: white">警情时间</span></td>
                <td><span style="color: white">确认</span></td>
            </tr>
            </thead>
            <tbody id="list" style="text-align: center"></tbody>
        </table>
    </div>
    <div class="div2">
    </div>
</div>
</body>
</html>