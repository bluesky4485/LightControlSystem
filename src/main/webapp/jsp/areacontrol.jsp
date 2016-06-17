<%--
  Created by IntelliJ IDEA.
  User: gch
  Date: 16-6-16
  Time: 下午2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>区域控制</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
</head>
<body style="text-align: center">
<div class="row">
    <div class="col-xs-3 col-xs-offset-3">
        <a href="areatimecontrol.jsp" class="btn btn-success active" target="areacontrol">
            定时控制
        </a>
    </div>
    <div class="col-xs-3">
        <a href="areaimcontrol.jsp" class="btn btn-success active" target="areacontrol">
            即时控制
        </a>
    </div>
</div>
<div class="row">
    <div class="col-xs-12 col-sm-12" style="height: 500px">
        <iframe name="areacontrol" style="width: 100%;height: 100%" scrolling="no" frameborder="no" src="areatimecontrol.jsp">
        </iframe>
    </div>
</div>
</body>
</html>
