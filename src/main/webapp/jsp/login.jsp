<%@ page contentType="text/html; charset=utf-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <%--<link href="../css/bootstrap.css" rel="stylesheet" />--%>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <script src="../js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
    <script src="../js/login.js" type="text/javascript"></script>
</head>
<body>
    <div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">
        <img src="../img/loginbg.jpg" height="100%" width="100%"/>
    </div>
    <div>
        <div class="wrapper">
            <div class="container">
                <h1>登陆</h1>
                <form class="form" name="myform" id="login" method="post" action="login.do">
                    <input type="text" placeholder="用户名" id="username" name="username">
                    <input type="password" placeholder="密码" id="password" name="password">
                    <button type="submit" id="login-button" onclick="return checkform(this.form);">登陆</button>
                </form>
            </div>
        </div>
    </div>

<%--<form class="form" name="myform" id="login" method="post" action="login.do">--%>
    <%--<input type="text" placeholder="Username" id="username" name="username">--%>
    <%--<input type="password" placeholder="Password" id="password" name="password">--%>
    <%--<button type="submit" id="login-button" onclick="return checkform(this.form);">Login</button>--%>
<%--</form>--%>
</body>

</html>