<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <link href="../css/jiemian.css" rel="stylesheet"/>

</head>
<body style="overflow-x: hidden ">
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <img src="../img/top.jpg" style="width: 100%"/>
            <div class="images-content">
                <h5>你好,${user.userName}!&nbsp;&nbsp;
                <a href="/">
                    <span onMouseOver="this.style.color='red'" onMouseOut="this.style.color='white'">
                    退出&nbsp;
                    </span>
                </a>
                </h5>
            </div>
        </div>
    </div>
    <div class="row" style="background-color: #337ab7;height: 580px;">
        <div class="col-xs-2 col-md-2">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <div class="btn-group btn-block btn-group-vertical">
                        <a href="jsp/statement.jsp" target="right" class="btn btn-primary">
                            <img src="../img/1.png" style="width:30%"/>综合首页
                        </a>
                        <a href="jsp/map.jsp" target="right" class="btn btn-primary">
                            <img src="../img/2.png" style="width:30%"/>地图监控
                        </a>
                        <a href="jsp/control.jsp" target="right" class="btn btn-primary">
                            <img src="../img/3.png" style="width:30%" />控制策略
                        </a>
                        <a href="jsp/warning.jsp" target="right" class="btn btn-primary">
                            <img src="../img/4.png" style="width:30%" />故障报警
                        </a>
                        <a href="jsp/query.jsp" target="right" class="btn btn-primary">
                            <img src="../img/5.png" style="width:30%" />操作查询
                        </a>
                        <a href="jsp/area.jsp" target="right" class="btn btn-primary">
                            <img src="../img/6.png" style="width:30%" />区域分组
                        </a>
                        <a href="jsp/backup.jsp" target="right" class="btn btn-primary">
                            <img src="../img/7.png" style="width:30%" />备份还原
                        </a>
                        <a href="jsp/manage.jsp" target="right" class="btn btn-primary">
                            <img src="../img/8.png" style="width:30%" />系统管理
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-10 col-md-10">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <iframe name="right" class="iframe" scrolling="no" src="jsp/statement.jsp">
                    </iframe>
                </div>
            </div>
        </div>
    </div>

</div>
<%--<div id='overlay'>--%>
    <%--<img src="../img/bot.png"  title="I love you cxh" alt="无法显示"/>--%>
<%--</div>--%>
</body>
</html>
