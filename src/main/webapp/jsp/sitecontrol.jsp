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
</head>
<body style="text-align: center;width: 100%">
   <div style="margin: 0 auto;width: 70%;">
        <div style="height: 50px;margin: 20px auto;">
            <div style="margin:0 auto;align-self: center">
                <div style="float: left">
                    经度
                    <input type="text"/>
                </div>
                <div style="float: left">
                    &nbsp;&nbsp;纬度
                    <input type="text"/>
                </div>
                <div style="float: left">
                    <input type="radio" name="controlmethod" value="0"/>手动
                </div>
            </div>
        </div>
        <div style="height: 100px;">
            <div style="float: left">
               经度
               <input type="text"/>
            </div>
            <div style="float: left">
                &nbsp;&nbsp;纬度
               <input type="text"/>
            </div>
            <div style="float: left">
               <input type="radio" name="controlmethod" value="1"/>自动
            </div>
        </div>
        <div>
           <button>控制</button>
        </div>
   </div>
</body>
</html>
