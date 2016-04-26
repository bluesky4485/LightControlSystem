<%--elvariable id="user" type="com.gaogandeng.model.User" --%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <link href="../css/jiemian.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jiemian.js"></script>
</head>
<body>
<div style="position: absolute; height:100%;width:100%;background-repeat:no-repeat;">
    <!--上部-->
    <div style=" height:90px;">
            <!--上左-->
            <div style="float:left;margin-top: 15px;width: 48%;">
                <h2 style="color: honeydew;text-align: center">高杆灯照明系统</h2>
            </div>
            <!--上右-->
            <div style="float:right; margin-top: 35px;">
                <table>
                    <tr>
                        <td><h5 style="color:white">你好,</h5></td>
                        <td><h5 style="color:red">${user.userName}!&nbsp;&nbsp;</h5></td>
                        <td><a href="/"><h5 style="color: white">退出&nbsp;</h5></a></td>
                    </tr>
                </table>
            </div>
    </div>
    <!--中左-->
    <div id="left1"style="float:left;height:85%;width:15%;margin-top: 5px;">
            <input id="hide" type="button" value="<<" class="btn-primary" style="width:98%;"/>
            <div id="left" style="width:98%;height:90%">
                <a href="jsp/right1.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height: 10%;">
                        <h4>综合首页</h4>
                    </button>
                </a><br>
                <a href="jsp/right2.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height: 10%;">
                        <h4>灯具控制</h4>
                    </button>
                </a><br>
                <a href="jsp/right3.jsp" target="right">
                    <button id="buttonwarn" class="btn-primary" style="width:100%;height: 10%;">
                        <h4>故障报警</h4>
                    </button>
                </a><br>
                <a href="jsp/right4.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height:10%;">
                        <h4>操作查询</h4>
                    </button>
                </a><br>
                <%--<a href="jsp/right5.jsp" target="right">--%>
                    <%--<button type="button" class="btn-primary" style="width: 180px;height: 60px;">--%>
                        <%--<h4>管理策略</h4>--%>
                    <%--</button>--%>
                <%--</a><br>--%>
                <a href="jsp/right6.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height:10%;">
                        <h4>系统管理</h4>
                    </button>
                </a><br>
            </div>
    </div>
    <!--中右-->
    <div style="float:left;height:85%;width:85%;">
            <iframe name="right" style="height:98%;width:98%;margin:0 auto;" src="jsp/right1.jsp">
            </iframe>
    </div>
    <!--底部-->
    <div class="navbar-fixed-bottom" style="height:5%;" >
            <h4><p class="text-center" style="color:whitesmoke;">高杆灯照明系统</p></h4>
    </div>
</div>
</body>
</html>