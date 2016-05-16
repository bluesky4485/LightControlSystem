<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style="position: relative; height:100%;width:100%;background-repeat:no-repeat;">
    <!--上部-->
    <div style=" height:90px;position: relative;">
            <!--上左-->
            <div style="margin-left:15%;margin-top: 15px;position: absolute;">
                <h2 style="color: honeydew;text-align: center">大场景智能照明系统</h2>
            </div>
            <!--上右-->
            <div style="float:right; margin-top: 35px;margin-right: 30px;">
                <table>
                    <tr>
                        <td><h5 style="color:white;font-size: medium">你好,</h5>
                        <td><h5 style="color:#e4b9b9;font-size: medium">${user.userName}!&nbsp;&nbsp;</h5></td>
                        <td><a href="/"><span style="color: white;font-size: medium" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='white'">退出&nbsp;</span></a></td>
                    </tr>
                </table>
            </div>
    </div>
    <!--中左-->
    <div id="left1"style="float:left;height:85%;width:15%;min-width:150px;position: absolute;">
            <input id="hide" type="button" value="<<" class="btn-primary" style="width:98%;"/>
            <div id="left" style="width:98%;height:90%;min-height: 80%;;">
                <a href="jsp/right1.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height: 10%;min-height: 50px;">
                        <h4>综合首页</h4>
                    </button>
                </a><br>
                <a href="jsp/right2.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height: 10%;min-height: 50px;">
                        <h4>灯具控制</h4>
                    </button>
                </a><br>
                <a href="jsp/right3.jsp" target="right">
                    <button id="buttonwarn" class="btn-primary" style="width:100%;height: 10%;min-height: 50px;">
                        <h4>故障报警</h4>
                    </button>
                </a><br>
                <a href="jsp/right4.jsp" target="right">
                    <button type="button" class="btn-primary" style="width:100%;height:10%;min-height: 50px;">
                        <h4>操作查询</h4>
                    </button>
                </a><br>
                <%--<a href="jsp/right5.jsp" target="right">--%>
                    <%--<button type="button" class="btn-primary" style="width: 180px;height: 60px;">--%>
                        <%--<h4>管理策略</h4>--%>
                    <%--</button>--%>
                <%--</a><br>--%>

                <%--<div <c:if test="${user.authority!= '1'}"> style="display: block;height:10%" </c:if><c:if test="${user.authority == '1' }">style="display: none" </c:if>>--%>
                <%--<c:if test="${user.authority!= '1'}">--%>
                    <%--<a href="jsp/right6.jsp" target="right" style="">--%>
                        <%--<button type="button" class="btn-primary" style="width:100%;height:10%;min-height: 50px;">--%>
                            <%--<h4>系统管理</h4>--%>
                        <%--</button>--%>
                    <%--</a><br>--%>
                <%--</c:if>--%>

                <c:choose>
                    <c:when test="${user.authority == 0}">
                        <a href="jsp/right6.jsp" target="right" style="">
                            <button type="button" class="btn-primary" style="width:100%;height:10%;min-height: 50px;">
                                <h4>系统管理</h4>
                            </button>
                        </a><br>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

                <%--</div>--%>
            </div>
    </div>
    <!--中右-->
    <div style="margin-left:15%;height:85%;width:85%;position:absolute;">
            <iframe name="right" style="height:98%;width:98%;margin:0 auto;" src="jsp/right1.jsp">
            </iframe>
    </div>
    <!--底部-->
    <div class="navbar-fixed-bottom" style="height:5%;">
            <h4><p class="text-center" style="color:whitesmoke;">高杆灯照明系统</p></h4>
    </div>
</div>
</body>
</html>