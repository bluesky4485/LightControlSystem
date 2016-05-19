<%--
  Created by IntelliJ IDEA.
  User: biny
  Date: 16-5-18
  Time: 上午10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
</head>
<body style="text-align: center;width: 100%">
<div style="margin: 0 auto;width: 90%">
    <div style="height: 5%;width: 100%;margin-top: 10px;">
        <a target="area" href="addarea.jsp"><button>增加区域</button></a>
        <%--<button>编辑区域</button>--%>
        <%--<a target="area" href="deletearea.jsp"><button>删除区域</button></a>--%>
    </div>
    <div style="height: 90%;width: 100%;">
        <iframe name="area" src="displayarea.jsp" style="width: 100%;height: 100%">
        </iframe>
    </div>
</div>
</body>
</html>
