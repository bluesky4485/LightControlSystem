<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />

</head>
<body>
<div style="width: 1148px;">
    <div style="margin-left:250px; ">
    <a href="<c:url value="/jsp/adduser.jsp"/>"><h4 style="text-decoration:underline">增加用户</h4></a>
    </div>
    <table style="width:600px;margin-left: 250px;border: 1px solid">
        <thead>
        <tr style="background-color: #215867;text-align: center;">
            <td><span style="color: white">#</span></td>
            <td><span style="color: white">用户名</span></td>
            <td><span style="color: white">密码</span></td>
            <td><span style="color: white">电话</span></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        </thead>
        <tbody id="list" style="text-align: center">
        </tbody>
        <%--下面输出用户列表--%>
    </table>
</div>
<script src="../js/jquery/jquery-1.9.1.js"></script>
<script src="../js/right6.js"></script>
</body>
</html>