<%--
  Created by IntelliJ IDEA.
  User: biny
  Date: 16-5-18
  Time: 上午10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>区域分组</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
</head>
<body>
    <div class="row">
        <br>
        <div class="col-sm-12" style="text-align: center">
            <a target="area" href="addarea.jsp"><button class="btn btn-primary">增加区域</button></a>
        </div>
    </div>

    <hr style="border: 1px #2b669a solid"/>

    <div class="row">
        <div class="col-sm-12" style="height: 500px;">
            <iframe name="area" src="displayarea.jsp" scrolling="no" frameborder="no" style="width: 100%;height: 100%">
            </iframe>
        </div>
    </div>
</body>
</html>
