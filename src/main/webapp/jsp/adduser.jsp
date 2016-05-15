<%--
  Created by IntelliJ IDEA.
  User: gch
  Date: 16-4-14
  Time: 上午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>增加用户</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/adduser.js"></script>
</head>
<body style="text-align: center">
    <div style="margin: 0 auto;width: 70%">
        <font style="color: #1a8cff;font-size: 200%">增加用户&nbsp;&nbsp;&nbsp;&nbsp;
        </font><span style="color: red">(*)</span>必填
    </div>
    <div style="margin-top: 10px">
    <form class="form" name="form" id="adduser" method="post" action="adduser.do">

        <h3><font style="color: red">(*)</font>姓名
            <input type="text" placeholder="Username" id="username" name="username"/></h3>

        <h3><font style="color: red">(*)</font>密码
            <input type="password" placeholder="Password" id="password" name="password"/></h3>

        <h3>&nbsp;&nbsp;&nbsp;&nbsp;           电话
            <input type="text" placeholder="Phone" id="phone" name="phone"/></h3>

        <h3>&nbsp;&nbsp;&nbsp;&nbsp;           地址
            <input type="text" placeholder="Address" id="address" name="address"/></h3>

        <h3><font style="color: red">(*)</font>权限
            <input type="text" placeholder="0/1" id="authority" name="authority"/></h3>

        <button type="submit" id="adduser-button" onclick="return checkform(this.form);">提交</button>
    </form>
    </div>






</body>
</html>
