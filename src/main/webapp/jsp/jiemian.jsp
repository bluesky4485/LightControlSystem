<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <link href="../css/jiemian.css" rel="stylesheet" />
    <script src="../js/jiemian.js"></script>
</head>
<body>
<div class="div1">
    <!--上部-->
    <div class="divtop">
        <div class="images-wrapper">
            <img src="../img/top.jpg" style="height: 90px;width: 100%;"/>
            <div class="images-content">
                <table>
                    <tr>
                        <td><h5 class="text1">你好,</h5>
                        <td>
                            <h5 style="color:#ff4433;font-size: medium">
                            ${user.userName}!&nbsp;&nbsp;
                            </h5>
                        </td>
                        <td>
                            <a href="/">
                            <span  class="text1" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='white'">
                                退出&nbsp;
                            </span>
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!--中左-->
    <div id="left1" class="divmid">
            <div id="left" style="width:98%;height:90%;min-height: 80%;;">
                <a href="jsp/statement.jsp" target="right">
                    <button type="button" class="mybtn">
                        <img src="../img/1.png" style="width:40px" />综合首页
                    </button>
                </a><br>
                <a href="jsp/map.jsp" target="right">
                    <button type="button" class="mybtn">
                        <img src="../img/2.png" style="width:40px" /><font>地图监控</font>
                    </button>
                </a><br>
                <a href="jsp/control.jsp" target="right">
                    <button type="button" class="mybtn">
                        <img src="../img/3.png" style="width:40px" /><font>控制策略</font>
                    </button>
                </a><br>
                <a href="jsp/warning.jsp" target="right">
                    <button id="buttonwarn" class="mybtn">
                        <img src="../img/4.png" style="width:40px" /><font>故障报警</font>
                    </button>
                </a><br>
                <a href="jsp/query.jsp" target="right">
                    <button type="button" class="mybtn">
                        <img src="../img/5.png" style="width:40px" /><font>操作查询</font>
                    </button>
                </a><br>

                <a href="jsp/area.jsp" target="right">
                    <button type="button" class="mybtn">
                        <img src="../img/6.png" style="width:40px" /><font>区域分组</font>
                    </button>
                </a><br>

                <a href="jsp/backup.jsp" target="right">
                    <button type="button" class="mybtn">
                        <img src="../img/7.png" style="width:40px" /><font>备份还原</font>
                    </button>
                </a><br>

                <c:choose>
                    <c:when test="${user.authority == 0}">
                        <a href="jsp/manage.jsp" target="right" style="">
                            <button type="button"  class="mybtn">
                                <img src="../img/8.png" style="width:30px" /><font>系统管理</font>
                            </button>
                        </a><br>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </div>
    </div>
    <!--中右-->
    <div class="divmid-right">
            <iframe name="right" class="iframe" src="jsp/statement.jsp">
            </iframe>
    </div>
    <!--底部-->
    <%--<div class="navbar-fixed-bottom" style="height:5%;">--%>
            <%--<h4><p class="text-center" style="color:#2b52cf;">高杆灯照明系统</p></h4>--%>
    <%--</div>--%>
</div>
</body>
</html>