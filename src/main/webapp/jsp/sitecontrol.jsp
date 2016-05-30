<%--
  Created by IntelliJ IDEA.
  User: biny
  Date: 16-5-20
  Time: 上午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经纬度控制</title>
    <script src="../js/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../js/sitecontrol.js"></script>
</head>
<body style="text-align: center;width: 100%">
   <div style="margin: 10% auto;width: 70%;">
        <div>
            <div>
                <input type="radio" id="manual" name="controlmethod" value="0" checked="checked"/>手动
                <input type="radio" id="auto" name="controlmethod" value="1" />自动
            </div><br>
            <div>
                经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度
                <input type="text" id="longitude"/>
            </div><br>
            <div>
                纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度
                <input type="text" id="latitude"/>
            </div><br>
            <div>
                控制天数
                <input type="text" id="controldays" placeholder="默认永久(0)"/>
            </div><br>
        </div><br>
        <div>
            <input type="button" id="sitecontrol" value="控制"/>
        </div>
   </div>
</body>
</html>
