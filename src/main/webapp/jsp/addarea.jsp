<%--
  Created by IntelliJ IDEA.
  User: biny
  Date: 16-5-18
  Time: 上午11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加区域</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/addarea.js"></script>

</head>
<body>
<div style="margin: 0 auto;width: 70%;text-align: center">
    <div>
        <font style="color: #1a8cff;font-size: 200%">增加区域&nbsp;&nbsp;&nbsp;&nbsp;</font>
    </div>
    <div style="margin-top: 10px">
        <form class="form" name="form" id="addarea" method="post" action="addarea.do">

            <h3>区域编号
                <input type="text" placeholder="区域编号" id="areaid" name="areaid"/></h3>

            <h3>区域名称
                <input type="text" placeholder="区域名称" id="areaname" name="areaname"/></h3>

            <h3>灯&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号
                <%--<input type="text" placeholder="灯号" id="lights" name="lights"/></h3>--%>
            <select id="lights" name="lights" multiple="multiple">
                <option value="498;">498</option>
                <option value="499;">499</option>
                <%--<option value="opel">Opel</option>--%>
                <%--<option value="audi">Audi</option>--%>
            </select>
            </h3>
            <button type="submit" id="adduser-button" onclick="return checkform(this.form);">确定</button>
        </form>
    </div>
</div>

</body>
</html>
