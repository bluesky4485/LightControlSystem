<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en" xmlns:http="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>警情处理</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <link href="../css/warning.css" rel="stylesheet" />


</head>

<body style="text-align: center">
<textarea id="template" style="display:none">
       {#foreach $T as record}
                  <tr>
                      <td>{$T.record.id}</td>
                      <td>{$T.record.light.deviceId}</td>
                      <td>{$T.record.light.groupId}</td>
                      <td>{$T.record.light.inGroupId}</td>
                      <td>{$T.record.info}</td>
                      <td>{#if $T.record.status==1} Y {#else} N {#/if}</td>
                      <td>{$T.record.infoTime}</td>
                      <td><button onclick="deleteRow()">确认</button></td>
                  </tr>
       {#/for}
</textarea>
<table id="test" align="center" class="table table-hover">
    <thead>
    <tr>
        <td>#</td>
        <td>控制器</td>
        <td>具体组号</td>
        <td>具体灯号</td>
        <td>警情原因</td>
        <td>已处理(Y/N)</td>
        <td>警情时间</td>
        <td>确认</td>
    </tr>
    </thead>
    <tbody id="result"></tbody>
</table>
<div style="margin: auto auto">

    <button onclick="firstPage()">第一页</button>
    <button onclick="prePage()">上一页</button>
    <button onclick="nextPage()">下一页</button>

</div>
<script src="../js/jquery/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/pagination.js"></script>
<script  type="text/javascript" src="../js/jquery-jtemplates.js"></script>
<script src="../js/warning.js"></script>
</body>
</html>